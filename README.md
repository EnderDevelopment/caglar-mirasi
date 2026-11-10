# Minecraft Mod Paketi: Hexxit: Çağların Mirası

Hexxit tarzı bir Minecraft macera mod paketi taslağı olan Hexxit: Çağların Mirası; kale ve kule keşfi, zindanlar, boss savaşları, teknoloji, büyü, görev ilerlemesi, alan madenciliği ve ırk seçimi temalarını bir araya getirir. Paket listesi Fabric 1.20.1 içindir ve ırk seçimi ile yetenek komutlarını sağlayan küçük bir özel çekirdek mod içerir.

## Install

1. Minecraft 1.20.1, Fabric Loader ve Java 17 kurun.
2. Bu projeyi klonlayın veya indirin.
3. Özel çekirdek modunu derlemek için proje klasöründe `./gradlew build` komutunu çalıştırın. Oluşan `build/libs` JAR dosyasını Fabric profilinizin `mods` klasörüne ekleyin.
4. `modpack/manifest.json` içindeki modları ve gerekli bağımlılıklarını, Minecraft 1.20.1 Fabric sürümleriyle resmi proje sayfalarından temin edip aynı `mods` klasörüne ekleyin.
5. Oyunu başlatın; eksik veya uyumsuz modlar için başlatıcı günlüğünü kontrol edin.

Manifest, içe aktarılabilir bir başlatıcı paketi veya üçüncü taraf mod dosyalarını içermez. FTB Ultimine ve diğer modların uygun Fabric 1.20.1 sürümlerini kurulumdan önce doğrulayın.

## Use

1. Dünyaya girdikten sonra `/race human`, `/race elf`, `/race dwarf` veya `/race orc` komutlarından biriyle ırk seçin. Seçiminizi `/race status` ile görüntüleyin.
2. Yetenek puanı almak için `/skill points earn`, puan ve açılmış yetenekleri görmek için `/skill status` kullanın. Bu puan komutu ayrıca bir ödül sistemiyle kısıtlanmadığından, çok oyunculu sunucularda erişimini dikkatle yönetin.
3. Bir yeteneği açmak için `/skill unlock vitality`, `/skill unlock power`, `/skill unlock agility`, `/skill unlock miner`, `/skill unlock arcane`, `/skill unlock berserker`, `/skill unlock shadowstep` veya `/skill unlock battlefocus` komutunu kullanın.
4. Açılmış etkin yetenekleri `/skill use berserker`, `/skill use shadowstep` veya `/skill use battlefocus` ile çalıştırın. Diğer beş yetenek pasiftir.
5. Görev ilerlemesini kurmak için `modpack/quests/quest-tree.md` dosyasındaki bölüm ve görev planını FTB Quests içinde oluşturun. Görevler, ödüller ve modlu eşya hedefleri oyunda ayrıca yapılandırılmalıdır; bu proje hazır bir FTB Quests görev dosyası içermez.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/0dac2a2a-b639-485b-acd7-56c55968e129?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=0dac2a2a-b639-485b-acd7-56c55968e129
