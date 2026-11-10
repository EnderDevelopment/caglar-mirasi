# RealmForge Quest Tree

A chapter-based FTB Quests progression plan for Minecraft 1.20.1 Fabric. Quest IDs are stable lowercase keys for planning and can be used as the basis for in-game quest IDs. Complete all quests in **Prologue** before the four core paths unlock. The core paths can then be played in any order; their milestones converge at **The Shattered Crown**.

## Character progression — The Adventurer's Skill Tree

Use the custom core mod commands as a lightweight server-authoritative skill system. Players start with no points; assign points through quest rewards or server-administered `/skill points earn`. Suggested FTB Quests milestones grant one skill point at `arrival`, `clear_courtyard`, `electric_age`, `arcane_trial`, and `dragon_roads` (configure command rewards or grant them manually). Each unlock costs one point and persists on the player.

| Branch | Skill | Type | Effect |
|---|---|---|---|
| Endurance | `vitality` | Passive | Health Boost I while unlocked |
| Vanguard | `power` | Passive | Strength I while unlocked |
| Scout | `agility` | Passive | Speed I while unlocked |
| Delver | `miner` | Passive | Haste I while unlocked |
| Arcanist | `arcane` | Passive | Resistance I while unlocked |
| Vanguard | `berserker` | Active | Strength II for 12 seconds |
| Scout | `shadowstep` | Active | Invisibility and Speed III for 5 seconds |
| Endurance | `battlefocus` | Active | Resistance II and Slowness I for 10 seconds |

Players inspect the tree with `/skill status`, unlock with `/skill unlock <skill>`, and activate active skills using `/skill use <skill>`. The custom core currently provides command-based unlocks and does not implement a graphical skill screen, cooldowns, or race-specific modifiers. Keep `/skill points earn` restricted to trusted staff on public servers and configure quest reward delivery accordingly.

## Chapter 0 — Prologue: Choose Your Legacy

| ID | Quest | Objective | Unlocks |
|---|---|---|---|
| `arrival` | A Realm Reforged | Enter the world; submit 1 crafting table | `choose_heritage`, `first_shelter` |
| `choose_heritage` | Choose Your Heritage | Choose one race/origin: Human, Elf, Dwarf, or Orc. Use the pack's race/origin selection system and claim the matching choice task/reward. | All four paths below |
| `first_shelter` | Shelter Before Sunset | Craft 1 bed and 1 stone pickaxe | `road_and_ruin` |
| `road_and_ruin` | Road to the Ruins | Discover a generated structure or dungeon | `tower_path`, `deep_delves` |

**Race rewards:** Human — bread ×8; Elf — arrows ×16; Dwarf — iron ingots ×8; Orc — cooked beef ×8. These are one-time starter gifts. If Origins is installed, configure matching origins separately; this quest records a themed choice and does not itself grant origin powers.

## Chapter 1 — The Broken Frontier

| ID | Quest | Objective | Unlocks |
|---|---|---|---|
| `tower_path` | The First Tower | Discover a tower; obtain 1 chest loot item | `clear_courtyard` |
| `clear_courtyard` | Clear the Courtyard | Defeat 8 hostile mobs | `relic_hunt`, `stronghold` |
| `relic_hunt` | Relics of the Old Kingdom | Obtain 1 enchanted book and 1 golden apple | `stronghold` |
| `stronghold` | The Fallen Keep | Discover a large dungeon/keep; obtain a key item or loot chest reward | `warden_of_stone` |
| `warden_of_stone` | Warden of Stone | Defeat a structure boss or dungeon miniboss; claim the trophy reward | `crown_shard_1` |
| `crown_shard_1` | First Crown Shard | Submit 1 diamond and 1 ender pearl | `shattered_crown` |

Use structure discovery and obtainable loot as objectives where exact structure IDs differ across installed structure mods. For boss kills, use the actual boss entity task if FTB Quests recognizes it; otherwise make the objective a trophy/item submission.

## Chapter 2 — The Engineer's Guild

| ID | Quest | Objective | Unlocks |
|---|---|---|---|
| `iron_age` | Forge the Basics | Obtain 32 iron ingots and 16 copper ingots | `power_source`, `create_workshop` |
| `power_source` | First Sparks | Craft the pack's basic Tech Reborn generator and connect a machine | `industrial_processing` |
| `industrial_processing` | Refine and Repeat | Craft a grinder and furnace; process 16 ores | `electric_age` |
| `electric_age` | Into the Electric Age | Craft an energy storage unit and an upgraded machine | `automated_supply` |
| `automated_supply` | A Reliable Supply | Produce 32 machine-processed ingots; submit 1 chest | `guild_contract` |
| `create_workshop` | Mechanical Workshop | Craft a Create water wheel and mechanical press | `moving_parts` |
| `moving_parts` | Moving Parts | Craft a mechanical mixer and deployer; automate one recipe | `guild_contract` |
| `guild_contract` | Guild Contract | Submit 16 treated/processed components and 1 redstone block | `crown_shard_2` |
| `crown_shard_2` | Second Crown Shard | Submit 1 diamond block and 1 ender pearl | `shattered_crown` |

Match machine and component task items to the exact recipes in the assembled mod versions. This avoids hard-coding item IDs that may change between releases.

## Chapter 3 — The Verdant and Veiled Arts

| ID | Quest | Objective | Unlocks |
|---|---|---|---|
| `herbalist` | Gather the Living World | Obtain 16 flowers, 16 logs, and 8 seeds | `botanical_apprentice`, `witching_hour` |
| `botanical_apprentice` | A Wandering Garden | Craft a Botania Lexica Botania and obtain 16 livingwood | `mana_pool` |
| `mana_pool` | The First Mana | Craft a mana pool and mana spreader; fill the pool | `living_automation` |
| `living_automation` | Nature at Work | Craft a functional Botania generating flower and submit 1 mana tablet | `arcane_trial` |
| `witching_hour` | The Witch's Kit | Craft a Bewitchment book/tool and obtain 8 mandrake roots | `ritual_circle` |
| `ritual_circle` | Draw the Circle | Build the ritual setup and complete one basic ritual | `arcane_trial` |
| `arcane_trial` | The Veiled Trial | Submit 1 mana tablet and 1 ritual-made item | `crown_shard_3` |
| `crown_shard_3` | Third Crown Shard | Submit 1 diamond and 1 ender pearl | `shattered_crown` |

Use the actual names and recipe outputs from the selected Botania and Bewitchment releases when configuring item tasks. Ritual completion can be represented by submitting its output item.

## Chapter 4 — The Far Roads

| ID | Quest | Objective | Unlocks |
|---|---|---|---|
| `field_kit` | Pack for the Unknown | Craft a compass, shield, and 16 torches | `biome_survey`, `deep_delves` |
| `biome_survey` | Survey the Wilds | Visit 3 distinct biomes | `end_expedition` |
| `deep_delves` | Beneath the Surface | Reach depth Y=0 or below; obtain 16 diamonds or equivalent rare loot | `dragon_roads` |
| `end_expedition` | Through the End Gate | Enter the End | `dragon_roads` |
| `dragon_roads` | The Dragon's Road | Defeat the Ender Dragon | `beyond_the_dragon` |
| `beyond_the_dragon` | Beyond the Dragon | Obtain an elytra and 1 shulker shell | `crown_shard_4` |
| `crown_shard_4` | Fourth Crown Shard | Submit 1 dragon head or equivalent End trophy | `shattered_crown` |

For worlds where players have already reached the End, use item submission and discovery tasks to permit catch-up.

## Chapter 5 — The Shattered Crown

| ID | Quest | Objective | Unlocks |
|---|---|---|---|
| `shattered_crown` | The Shattered Crown | Complete all four shard quests; submit 4 crown shards (use four custom quest rewards/items or four diamonds if no pack item exists) | `assemble_crown` |
| `assemble_crown` | Crown of the Realm | Submit a nether star, 4 diamonds, 4 ender pearls, 1 mana tablet, and 1 advanced machine component | `final_siege` |
| `final_siege` | Siege of the Black Spire | Discover the final tower/stronghold and defeat its boss; submit the boss trophy | `realmforge_champion` |
| `realmforge_champion` | Realmforge Champion | Claim the final reward: netherite ingot ×1, diamond ×4, and fireworks ×16 | — |

If the modpack has no custom crown or shard items, use distinct quest reward claims and the listed vanilla/modded submissions to represent each milestone. FTB Quests rewards are configured in-game per quest.

## Optional bounty board

These repeatable quests sit outside the main dependency chain and can be repeated for modest supplies:

- `bounty_hunt`: defeat 10 hostile mobs → cooked food ×8.
- `bounty_miner`: mine 32 stone/deepslate ores → torches ×16.
- `bounty_explorer`: discover a new biome or structure → bread ×8.
- `bounty_crafter`: craft 16 machine components → copper ingots ×8.

Set these quests repeatable in FTB Quests and keep rewards small to avoid trivializing progression.

## FTB Quests setup notes

Create six chapters named **Prologue**, **The Broken Frontier**, **The Engineer's Guild**, **The Verdant and Veiled Arts**, **The Far Roads**, and **The Shattered Crown**. Add quests using the IDs above, then connect each prerequisite as listed in the `Unlocks` column. Use item tasks for submissions, kill tasks for vanilla mobs/bosses supported by the installed FTB Quests version, and advancement/location tasks where available. Set party sharing through FTB Teams to match the pack's cooperative play. Configure exact item IDs by selecting items from the in-game task picker after all mods are installed; this plan intentionally avoids brittle guessed IDs for modded machines, rituals, structure loot, and boss trophies.
