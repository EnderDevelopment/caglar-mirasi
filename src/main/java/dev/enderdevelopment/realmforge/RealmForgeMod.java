package dev.enderdevelopment.realmforge;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Set;

import static net.minecraft.server.command.CommandManager.literal;

public final class RealmForgeMod implements ModInitializer {
    public static final String MOD_ID = "realmforge";
    private static final String[] RACES = {"Human", "Elf", "Dwarf", "Orc"};
    private static final String[] SKILLS = {"vitality", "power", "agility", "miner", "arcane", "berserker", "shadowstep", "battlefocus"};

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("race")
                .then(literal("human").executes(c -> chooseRace(c.getSource().getPlayer(), "Human", Formatting.GOLD)))
                .then(literal("elf").executes(c -> chooseRace(c.getSource().getPlayer(), "Elf", Formatting.GREEN)))
                .then(literal("dwarf").executes(c -> chooseRace(c.getSource().getPlayer(), "Dwarf", Formatting.GRAY)))
                .then(literal("orc").executes(c -> chooseRace(c.getSource().getPlayer(), "Orc", Formatting.DARK_GREEN)))
                .then(literal("status").executes(c -> showRace(c.getSource().getPlayer()))));
            dispatcher.register(literal("skill")
                .then(literal("status").executes(c -> status(c.getSource().getPlayer())))
                .then(literal("points").then(literal("earn").executes(c -> earn(c.getSource().getPlayer()))))
                .then(literal("unlock").then(literal("vitality").executes(c -> unlock(c.getSource().getPlayer(), "vitality")))
                    .then(literal("power").executes(c -> unlock(c.getSource().getPlayer(), "power")))
                    .then(literal("agility").executes(c -> unlock(c.getSource().getPlayer(), "agility")))
                    .then(literal("miner").executes(c -> unlock(c.getSource().getPlayer(), "miner")))
                    .then(literal("arcane").executes(c -> unlock(c.getSource().getPlayer(), "arcane")))
                    .then(literal("berserker").executes(c -> unlock(c.getSource().getPlayer(), "berserker")))
                    .then(literal("shadowstep").executes(c -> unlock(c.getSource().getPlayer(), "shadowstep")))
                    .then(literal("battlefocus").executes(c -> unlock(c.getSource().getPlayer(), "battlefocus"))))
                .then(literal("use").then(literal("berserker").executes(c -> use(c.getSource().getPlayer(), "berserker")))
                    .then(literal("shadowstep").executes(c -> use(c.getSource().getPlayer(), "shadowstep")))
                    .then(literal("battlefocus").executes(c -> use(c.getSource().getPlayer(), "battlefocus")))));
        });
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (has(player, "vitality")) player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 45, 0, true, false, false));
                if (has(player, "power")) player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 45, 0, true, false, false));
                if (has(player, "agility")) player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 45, 0, true, false, false));
                if (has(player, "miner")) player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 45, 0, true, false, false));
                if (has(player, "arcane")) player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 45, 0, true, false, false));
            }
        });
    }

    private static int chooseRace(ServerPlayerEntity player, String race, Formatting color) {
        player.addCommandTag("rf_race=" + race);
        player.sendMessage(Text.literal("Your race is now " + race + "." ).formatted(color), false);
        return 1;
    }

    private static int showRace(ServerPlayerEntity player) {
        String race = player.getCommandTags().stream().filter(t -> t.startsWith("rf_race=")).findFirst().orElse("rf_race=unselected").substring(8);
        player.sendMessage(Text.literal("Your race: " + race), false);
        return 1;
    }

    private static int points(ServerPlayerEntity player) {
        return player.getCommandTags().stream().filter(t -> t.startsWith("rf_points="))
            .map(t -> { try { return Integer.parseInt(t.substring(10)); } catch (NumberFormatException e) { return 0; } }).findFirst().orElse(0);
    }

    private static void setPoints(ServerPlayerEntity player, int value) {
        removePrefix(player, "rf_points=");
        player.addCommandTag("rf_points=" + value);
    }

    private static void removePrefix(ServerPlayerEntity player, String prefix) {
        Set<String> tags = Set.copyOf(player.getCommandTags());
        for (String tag : tags) if (tag.startsWith(prefix)) player.removeCommandTag(tag);
    }

    private static boolean has(ServerPlayerEntity player, String skill) {
        return player.getCommandTags().contains("rf_skill=" + skill);
    }

    private static int earn(ServerPlayerEntity player) {
        setPoints(player, points(player) + 1);
        player.sendMessage(Text.literal("You gained 1 skill point. Total: " + points(player)), false);
        return 1;
    }

    private static int unlock(ServerPlayerEntity player, String skill) {
        if (!Set.of(SKILLS).contains(skill)) return 0;
        if (has(player, skill)) { player.sendMessage(Text.literal("Already unlocked."), false); return 0; }
        if (points(player) < 1) { player.sendMessage(Text.literal("Not enough skill points. Use /skill points earn."), false); return 0; }
        setPoints(player, points(player) - 1);
        player.addCommandTag("rf_skill=" + skill);
        player.sendMessage(Text.literal("Unlocked " + skill + ". Remaining points: " + points(player)), false);
        return 1;
    }

    private static int use(ServerPlayerEntity player, String skill) {
        if (!has(player, skill)) { player.sendMessage(Text.literal("Unlock this skill first."), false); return 0; }
        switch (skill) {
            case "berserker" -> player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 12, 1));
            case "shadowstep" -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20 * 5, 0));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 5, 2));
            }
            case "battlefocus" -> {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 10, 1));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 10, 0));
            }
            default -> { player.sendMessage(Text.literal("That skill is passive."), false); return 0; }
        }
        player.sendMessage(Text.literal("Used " + skill + "."), false);
        return 1;
    }

    private static int status(ServerPlayerEntity player) {
        player.sendMessage(Text.literal("Skill points: " + points(player)), false);
        String unlocked = String.join(", ", player.getCommandTags().stream().filter(t -> t.startsWith("rf_skill=")).map(t -> t.substring(9)).toList());
        player.sendMessage(Text.literal("Unlocked: " + (unlocked.isEmpty() ? "none" : unlocked)), false);
        return 1;
    }
}
