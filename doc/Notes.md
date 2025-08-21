### C ve Sistem Programcıları Derneği
### Java ile Uygulama Geliştirme 1
### Eğitmen: Oğuz KARAN

##### Maven ile Kütüphane Kullanımı

Genel olarak bir kütüphane `maven` build aracı ile aşağıdakilerden biri ya da birkaçından kullanılabilir:
1. Uygulama geliştirilirken kullanılan host makinenin içerisindeki `maven local repository` ile kullanılabilir. Bu repository maven programı geçerli veya geçersiz ilk kez çalıştırıldığında genel olarak `.m2` isimli bir directory biçiminde yaratılır. Bu directory'nin aslında default ismi ve default yeri değiştirilebilir. Ancak pratikte özel durumlar dışında ismi ve yeri değiştirilmez. mvn programı install seçeneği ile doğrudan çalıştırıldığında konfigürasyona göre ilgili kütüphane maven local repository'ye yüklenir. Aşağıda linki verilen demo uygulamayı inceleyiniz:
 [001-DemoMavenLocalAndSystemScope](https://github.com/oguzkaran/JavaApp1-Aug-2025/tree/main/src/Projects/001-DemoMavenLocalAndSystemScope)
 
2. Projenin içerisinden ancak başka bir path'den kullanılabilir. Genelde bu kullanımda kütüphane, proje içerisinde bir directory'ye konuşlandırılır ve dependency olarak `<systemPath>` içerisinde belirtilerek projeye dahil edilir. Bu kullanımda kütüphanenin update edilmesi gibi durumlarını yönetmek zor olabilmektedir. Bu sebeple, bu kullanımda maven uzun zamandır uyarı vermektedir. Bu uyarı bu kullanımın deprecated olduğu ve ileride devre dışı kalacağına yöneliktir. Aşağıda linki verilen demo uygulamayı inceleyiniz:
[001-DemoMavenLocalAndSystemScope](https://github.com/oguzkaran/JavaApp1-Aug-2025/tree/main/src/Projects/001-DemoMavenLocalAndSystemScope)
 
3. Özel olarak configure edilmiş ve kütüphanelerin uygun şekilde maven tarafından install edilebildiği remote repository'lerden kullanılabilir. Bu tarz bir repository oluşturmanın Java ve maven dışında da ayrıntıları vardır. Burada bu tarz bir server'ı oluştrma ele alınmayacaktır. Github maven remote repository oluşturmayı destekler. Burada github üzerinde remote repository oluşturmayı ele alacağız ve kurs boyunca genel kütüphanelerimizi remote repository'lere içerisine atıp oradan kullanacağız. Github üzerinde remote bir repository oluşturmanın ve remote repository'ye install etmenin genel adımları şunlardır:

```
git clone https://github.com/oguzkaran/javaapp1-aug-2025-maven-repo
```

```
git clone https://github.com/oguzkaran/javaapp1-aug-2025-maven-repo
```

```
git config --global user.email "your email"
```


 Klonlanan repository'ye ilgili kütüphane dosyasının maven ile install edilmesi için aşağıdaki örnek komut kullanılabilir:

```
mvn install:install-file -DgroupId=org.csystem -DartifactId=org-csystem-util -Dversion=1.0.0 -Dfile=../jars/org-csystem-util-1.0.0.jar -Dpackaging=jar -DgeneratePom=true -DlocalRepositoryPath=. -DcreateChecksum=true
```

```
git add -A . && git commit -m "released version 1.0.0"
```

```
git push
```

console ile add, commit ve push işlemi için güvenlik açısından bazı github konfigürasyonları gerekir. İstenirse github desktop daha görsel kullanılan araçlar ile de yapılabilir.

Github'ın maven repository için default olarak belirlediği url (uniform resource location) için genel biçimi şu şekildedir:

```
https://raw.github.com/<github username>/<github repository name>/<branch name>`
```

Örneğin

```
https://raw.github.com/oguzkaran/javaapp1-aug-2025-maven-repo/main
```

```
https://raw.github.com/oguzkaran/javaapp1-aug-2025-karandev-maven-repo/main
```



Burada default branch name `main` ismi ile belirlenir. Remote repository'ler `<repositories>` elemanı altında pom dosyasında belirtilir.
```xml
<repositories>  
    <repository>  
        <id>javaapp1-aug-2025-maven-repo</id>  
        <url>https://raw.github.com/oguzkaran/javaapp1-aug-2025-maven-repo/main</url>  
    </repository>  
  
    <repository>  
        <id>javaapp1-aug-2025-karandev-maven-repo</id>  
        <url>https://raw.github.com/oguzkaran/javaapp1-aug-2025-karandev-maven-repo/main</url>  
    </repository>  
</repositories>
```

4. Apache firmasının sunduğu Maven Central denilen bir server'dan kullanılabilir. Bu durumda ilgili kütüphanenin bu server içerisinde install edilmesi gerekir. Maven central kullanımı ileride ele alınacaktır.

Maven bir kütüphanenin dependency'sini gördüğünde eğer 2. kullanım durumu yoksa aramayı belli bir sırada yapar. Bu sıra şu şekildedir:
- maven local repository

- maven central

- maven remote repositories

Eğer maven central'da veya maven remote repository'de bulursa yine maven local repository'ye indirir. Yani sonuçta maven 2. kullanım hariç kütüphaneyi maven local repository'den kullanır.

##### Yazılımda Test Süreçleri

Yazılımda test süreçleri ürün geliştirmenin önemli bir aşamasını oluşturmaktadır. Bazı yazılımlarda, ürünün her şeyiyle doğru olması kritik öneme sahip olabilmektedir. Bazı yazılımlarda hata toleransları olabilir. Gerektiğinde düzeltilebilir.

Eskiden yazılım geliştirmede test süreçleri lüks olarak değerlendiriliyordu. Bu nedenle yalnızca büyük firmalar test bölümleri barındırıyorlardı. Ancak günümüzde yazılımda kalite (software quality) bilinci daha fazla artmış ve test süreçleri daha bilinir ve kullanılır hale gelmiştir.

Yazılımda test süreçleri için çeşitli stratejiler kullanılabilmektedir. Test işlemi en aşağı düzeyde programcının kendi yazdığı kodları test etmesi ile başlar. Buna "birim testi (unit testing)" denir. Programcı genel olarak, yazmış olduğu bir metodun doğru çalışıp çalışmadığını test eder (duruma göre "etmelidir"). İşte burada bir metot bir "birim (unit)" olarak düşünülür. Bir yazılımda aslında parçalar bir araya getirilir. Yani metotlar çağrılarak yazılım geliştirilir. Bu bir araya getirme işlemi sonucunda genellikle parçalar yeniden test edilir. Buna da "entegrasyon testi (integration testing)" denilmektedir. Yazılımın önemli parçalarına "modül (module)" denir. Modüller de ayrı ayrı test edilebilir. Buna da "modül testi (module testing)" denir. Nihayet ürün oluşturulur ve bir bütün olarak test edilir. Genellikle bu testlere "kabul testleri (acceptance testing)" denir. Ürün bir bütün olarak önce kurum içerisinde test bölümleri tarafından test edilir. Genellikle bu testlere "alfa testi (alpha testing)" denir. Sonra ürün seçilmiş bazı son kullanıcılara dağıtılır ve gerçek hayat testine sokulur. Buna genellikle "beta testi (beta testing)" denir.


Birim testi için pratikte şu 3 yaklaşımdan biri uygulanır:

- Hiç birim testi yapmamak: Bu durum yazılım geliştirmede tavsiye edilmese de bir takım özel sebeplerden dolayı firmalar tarafından uygulanabilmektedir. Örneğin geliştirici ekibin sayı olarak azlığı, projenin deadline'ının kısa olması, rakip firmalardan önce ürünü çıkarma kaygısı vb. durumlarda karşılaşılabilmektedir. Buradaki yaklaşım programcının hiç test yapmaması değil, programcıdan bir test beklentisi olmaması ya da özellikle test yapmasının istenmemesi gibi düşünülebilir. Şüphesiz programcı geliştirme sürecinde belirli ölçüde test yapacaktır.

- Katı katıya birim testi yapmak: Bu durumda neredeyse her birim test edilir. Örneğin bir metodun basit ya da karmaşık olmasına bakılmaksızın birim testi yapılır. Bu durumda zaman kaybı olmaması için birim testi yapan programcıların ayrı olması ideal bir durumdur. Şüphesiz herhangi bir zaman kısıtı yoksa ya da zaman çok uzunsa da uygulanabilir.

- Gereken birimler için birim testi yapmak: Aslında görünürde en ideal durum budur. Görece basit birimler test edilmez ya da detaylı olarak test edilmez. Bu durumda hangi birimlerin test edileceğinin, hangi birimlerin belirli ölçüde test edileceğinin, hangi birimlerin test edilmeyeceğinin belirlenmesi önemlidir. Bu da geliştiriciler ve yöneticiler açısından tecrübe gerektirebilir.

Birim testleri genel olarak iki şekilde yapılır: manuel birim testleri, bazı araçlar ile otomatik olarak yapılan birim testleri. Pratikte duruma göre ikisi de tercih edilebilse de otomatik araçlar ile yapılan testler belirli ölçüde testi yapan programcının gereksiz kodları yazmasını engellediğinden daha çok tercih edilir. Hatta bazı firmalar kendi birim testi araçlarını da yazarlar.

Java'da temel birim testi aracı **JUnit** olsa da Spring gibi popüler framework'lere ait olan ya da olmayan bir çok farklı araç da söz konusudur. Birim testleri IDE programlar ve build araçları ile daha kullanışlı hale gelir. Aslında bu araçların temel amacı birim testini yapan programcının test işlemini mümkün olduğunca otomatize etmektir. Bu araçlar ile çoğu durumda, her zaman yazılması gereken kodları programcıya bırakılmaz. Bu durumda programcı için önemli olan yani odaklanması gereken test senaryolarını belirlemek ve yazmaktır. Bu senaryolar için her zaman genel olan durumlar söylenemez. Test edilecek birimin ne olduğuna göre, nasıl test edileceğine göre vb. durumlar için değişiklik gösterebilir.

Birim test araçlarının çoğunda kullanılan genel bazı terimler vardır: **setup, teardown, input, expected, actual vb.**









