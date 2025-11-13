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

**setup:** Test metodunun çağrılmasından önce yapılması gereken ilk işlemlerdir.
**teardown:** Test metodunun çağrılmasından sonra yapılması gereken son işlemlerdir.
**input:** Test yapılacak birimin girdisidir.
**expected:** Test yapılacak birimin beklenen sonucudur.
**actual:** Test yapılmış birimden elde edilen sonuçtur.

Şüphesiz her birim için bu kavramların kullanılması gerekmez.

**Anahtar Notlar:** Test işlemlerinde karşılaştığımız önemli iki terim vardır: **Verification & Validation (V&V)**. Verification, yazılmış olan kodun doğru çalışmasıdır. Validation ise kodun doğru işi yapmasıdır.

##### var Değişkenler

`var` sözcüğü Java 10 ile birlikte dile eklenmiştir. `var` sonradan eklendiği için kullanıldığı yere göre değişken ismi veya anahtar sözcük gibi ele alınır. Bu tarz sözcüklere programlamada `contextual keyword` de denildiğini anımsayınız. var yalnızca yerel değişkenlerde ve Java 11 ile birlikte ileride ele alacağımız `lambda ifadeleri` ile birlikte kullanılabilmektedir. var değişkenlerin ilk değerlenmesi (initialization) zorunludur. Derleyici ilk değer olarak verilen ifadenin türüne göre değişkenin türünü tespit eder. Derleyicinin bir değişkenin türünü tespit etmesi kavramına **type inference** ya da **type deduction** denir. var değişkenlerin türleri çalışma zamanında değişmez. Anımsanacağı gibi Java'da bir değişkenin türü hiç bir zaman değişmez.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = 10;  
        var b = 3.4;  
        var c = "ankara";  
        var d  = a++;  
        var e = 3.4F;  
  
        Console.writeLine("a = %d, b = %f, c = %s, d = %d, e = %f", a, b, c, d, e);  
    }  
}
```

>Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a; //error  
  
        a = 10;  
    }  
}
```

var değişkenler for döngü deyiminde de kullanılabilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Random;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var random = new Random();  
        var n = Console.readInt("Input count:");  
  
        for (var i = 0; i < n; ++i)  
            Console.write("%d ", random.nextInt(1, 100));  
  
        Console.writeLine();  
    }  
}
```

var değişkenler for-each döngüsünde de kullanılabilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.util.array.ArrayUtil;  
  
import java.util.Random;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var random = new Random();  
        var n = Console.readInt("Input count:");  
        var a = ArrayUtil.generateRandomArray(random, n, 1, 100);  
          
        for (var val : a)  
            Console.write("%d ", val);  
  
        Console.writeLine();  
    }  
}
```

var değişkenler virgül ile ayrılacak şekilde bildirilemez

```java
package org.csystem.app;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = 10, b = 20;   //error
  
  
    }  
}
```

`var değişkenler` mümkün olduğunca kullanılmalıdır. Bu anlamda bazı programcılar temel türler (primitive types) dışında mümkün olduğunca kullanmayı tercih ederler. Biz, tür ne olursa olsun kullanılabildiği her yerde kullanmayı tercih edeceğiz (always applicable).

**Anahtar Notlar:** var değişkenlere ilişkin diğer detaylar konular içerisinde ele alınacaktır.

##### Kodun Çalışma Süresinin Ölçülmesi

Bazen program içerisinde bir kod parçasının (code snippet) ne kadar sürede tamamlandığının ölçülmesi gerekebilir. Bu işlem, kod parçasının başında o an ki zaman bilgisi alınıp, kodun bitiminde de tekrar zaman bilgisi alınarak hesaplanabilir. Bu zaman, takvim zamanı (calendar time) çok hassas işlemlerde kullanılamaz. Bu durumda daha hassas ölçümler yapabilen yine zamana bağlı olarak hesaplanabilen değerler kullanılmalıdır. Bu işlemi yapmanın Java'da birden fazla yolu bulunmaktadır. Ayrıca 3. parti olarak yazılmış kütüphanelerin çeşitli sınıfları da kullanılabilmektedir. Hatta programcı isterse kendisi de böyle bir işlem için sınıf ya da sınıflar yazabilir. Bu 3. parti olarak yazılmış kütüphaneler içerisinde popüler olarak kullanılan iki tanesinde `StopWatch` isimli sınıflar bu işlem için tasarlanmışlardır. Bu popüler kütüphaneler tipik olarak `Google guava` ve `Apache commons` kütüphaneleridir. Aslında bu kütüphanelerde pek çok yardımcı sınıf ve metot da bulunmaktadır

System sınıfının static **currentTimeMillis** metodu 01.01.1970 00:00:00 UTC (geceyarısı) zamanından (epoch time) çağrıldığı tarih zamana kadar geçen milisaniye sayısına geri döner. Bu durumda süresi ölçülecek kodun başında ve sonunda bu metot çağrılır ve geri döndürdüğü değerlerin farkı alınır ve istenen zaman biriminde hesaplanabilir
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.util.numeric.NumberUtil;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var start = System.currentTimeMillis(); 
         
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal değil");  
        
        var end = System.currentTimeMillis();  
        var seconds = (end - start) / 1000.;  
  
        Console.writeLine("Duration:%f", seconds);  
    }  
}
```

System sınıfının static **nanoTime** metodu, `currentTimeMillis` metodundan görece daha hassas olacak şekilde bir bilgi döndürür. Bu bilgi nano-saniye mertebesindedir. Hassas ölçümlerde bu metodun kullanılması tavsiye edilir. Aşağıdaki örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.util.numeric.NumberUtil;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var start = System.nanoTime();  
        
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal değil");  
        
        var end = System.nanoTime();  
        var seconds = (end - start) / 1_000_000_000.;  
  
        Console.writeLine("Duration:%f", seconds);  
    }  
}
```

`Google Guava` kütüphanesinin maven dependency bilgisi notun yazıldığı tarihte şu şekildedir:

```
<dependency>  
    <groupId>com.google.guava</groupId>  
    <artifactId>guava</artifactId>  
    <version>33.4.8-jre</version>  
</dependency>
```

Aşağıdaki demo örnekte `Google Guava` kütüphanesinin `StopWatch` sınıfı kullanılmıştır

```java
package org.csystem.app;  
  
import com.google.common.base.Stopwatch;  
import com.karandev.io.util.console.Console;  
import org.csystem.util.numeric.NumberUtil;  
  
import java.util.concurrent.TimeUnit;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var stopwatch = Stopwatch.createStarted();  
  
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal değil");  
  
        stopwatch.stop();  
  
        var seconds = stopwatch.elapsed(TimeUnit.MILLISECONDS) / 1000.;  
  
        Console.writeLine("Duration:%f", seconds);  
    }  
}
```

`Apache Commons Lang` kütüphanesinin maven dependency bilgisi notun yazıldığı tarihte şu şekildedir:

```
<dependency>  
    <groupId>org.apache.commons</groupId>  
    <artifactId>commons-lang3</artifactId>  
    <version>3.18.0</version>  
</dependency>
```

Aşağıdaki demo örnekte `Apache Commons Lang` kütüphanesinin `StopWatch` sınıfı kullanılmıştır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.apache.commons.lang3.time.StopWatch;  
import org.csystem.util.numeric.NumberUtil;  
  
import java.util.concurrent.TimeUnit;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var stopwatch = new StopWatch();  
  
        stopwatch.start();  
  
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal değil");  
  
        stopwatch.stop();  
  
        var seconds = stopwatch.getTime(TimeUnit.MILLISECONDS) / 1000.;  
  
        Console.writeLine("Duration:%f", seconds);  
    }  
}
```

```
<dependency>  
    <groupId>org.csystem</groupId>  
    <artifactId>org-csystem-diagnostics</artifactId>  
    <version>1.0.0</version>  
</dependency>
```

kütüphanesinde bulunan `StopWatch` sınıfı ve kullanımı.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.diagnostics.StopWatch;  
import org.csystem.util.numeric.NumberUtil;  
  
import java.util.concurrent.TimeUnit;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var stopwatch = StopWatch.createStarted();  
  
        Console.writeLine(NumberUtil.isPrime(6750161072220585911L) ? "Asal" : "Asal değil");  
  
        stopwatch.stop();  
  
        var seconds = stopwatch.elapsedTime(TimeUnit.MILLISECONDS) / 1000.;  
  
        Console.writeLine("Duration:%f", seconds);  
    }  
}
```

```java
package org.csystem.diagnostics;  
  
import java.util.concurrent.TimeUnit;  

public class StopWatch {  
    private long m_start;  
    private long m_stop;  
  
    public static StopWatch create()  
    {  
        return new StopWatch();  
    }  
  
    public static StopWatch createStarted()  
    {  
        return (new StopWatch()).start();  
    }  
  
    public StopWatch start()  
    {  
        m_start = System.nanoTime();  
        return this;  
    }  
  
    public StopWatch stop()  
    {  
        m_stop = System.nanoTime();  
        return this;  
    }  
  
    public long elapsedTime(TimeUnit timeUnit)  
    {  
        return timeUnit.convert(m_stop - m_start, TimeUnit.NANOSECONDS);  
    } 
}
```

##### Değişken Sayıda Argüman Alan Metotlar

Değişken sayıda argüman alan metotlara Java dünyasında **variable length arguments method** ya da kısaca **varargs** method denir. Metot yazılırken `... (ellipsis)` atomu kullanıldığından bazı kaynaklar bu tarz metotlara **ellipsis parametreli metotlar** da denilmektedir. 

Değişken sayıda argüman alan metodun, değişken sayıda argüman alabilen parametresinin genel biçimi şu şekildedir

```java
<tür ismi>...<değişken ismi>
```

Örneğin, 

```java
void printInts(int...ints)
```

Ellipsis parametresi metot bildirimi açısından bir dizi referansıdır.

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        Util.printInts(10, 20, 30);  
        Util.printInts(10, 20);  
        Util.printInts();  
    }  
}  
  
class Util {  
    public static void printInts(int...ints)  
    {  
        for (var a : ints)  
            Console.write("%d ", a);  
  
        Console.writeLine();  
    }  
}
```

Ellipsis parametresi metodun son parametresi olmalıdır. Bu durumda bir metodun birden fazla ellipsis parametresi olamaz.

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        Util.printInts("Values", 10, 20, 30);  
        Util.printInts("Değerler", 10, 20);  
        Util.printInts("Boş");  
    }  
}  
  
class Util {  
    public static void printInts(String prompt, int...ints)  
    {  
        Console.write("%s:", prompt);  
        for (var a : ints)  
            Console.write("%d ", a);  
  
        Console.writeLine();  
    }  
}
```

Hem ellipsis parametreli hem de aynı türden dizi parametreli bir metot overload edilemez. Yani ellipsis parametresi dizi referans parametresine göre imzayı değiştirmez

```java
class Util {  
    public static void printInts(String prompt, int...ints)  //error
    {  
        //...
    }  
  
    public static void printInts(String prompt, int[]ints)  //error
    {  
        //... 
    }  
}
```

Aşağıdaki demo örnekteki birinci çağrıda `int` parametreli, ikinci çağrıda ise `int...` parametreli metot seçilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        Sample.foo(10); //1  
        Sample.foo(10, 20); //2  
    }  
}  
  
class Sample {  
    public static void foo(int a)  
    {  
        Console.writeLine("foo, int");  
    }  
  
    public static void foo(int...a)  
    {  
        Console.writeLine("foo, int...");  
    }  
}
```

Aşağıdaki demo örnekte `int -> long` dönüşümü  `int -> int...` dönüşümünden daha kaliteli olduğunda `long` parametreli metot çağrılır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        Sample.foo(10);  
    }  
}  
  
class Sample {  
    public static void foo(long a)  
    {  
        Console.writeLine("foo, long");  
    }  
      
    public static void foo(int...a)  
    {  
        Console.writeLine("foo, int...");  
    }  
}
```

Aşağıdaki demo örnekte `int -> int...` dönüşümü  `int -> long...` dönüşümünden daha kaliteli olduğunda `int...` parametreli metot çağrılır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        Sample.foo(10);  
    }  
}  
  
class Sample {  
    public static void foo(long...a)  
    {  
        Console.writeLine("foo, long...");  
    }  
  
    public static void foo(int...a)  
    {  
        Console.writeLine("foo, int...");  
    }  
}
```

##### git Versiyon Kontrol Sistemi

git, özellikle yazılım geliştirmede kullanılan bir versiyon takip aracıdır. git, 2005 senesinde `Linus Torvalds` tarafından `Linux çekirdek projesi (Linux Kernel Project)` kapsamında geliştirilmiştir. İlerleyen senelerde pek çok firma ve geliştirici tarafından kullanılır duruma gelmiştir. git'in önemli iki özelliği `dağıtık (distributed)` olması ve güvenli bir biçimde yapılan işlemlerin geçmişini (history) tutabilmesidir. Dağıtık demekle, git ile çalışan bir proje bulunduğu ana bilgisayarın dışında başka bilgisayarlara da kopyalanıp aynı anda geliştirme yapılabilmektedir. Kendi lokalinde çalışan yazılımcılar aynı zamanda yaptıklarını ana bilgisayara aktarabilirler ve bütün bu yapılanların geçmişi git tarafından tutulur ve kopyalayan da kendi lokalinde bu geçmişe sahip olabilir. git üzerinde burada anlatılanların ve diğer detaylar için bir terminolojisi bulunur. git günümüzde pek çok IDE veya benzeri uygulamalar tarafında görsel olarak da desteklenmektedir.
###### git Kurulumu

git komut satırından çalışan bir uygulamadır. Tipik olarak tüm sistemler için geliştirilmiştir. Unix/Linux sistemleri ve Mac OS X sistemleri için ilgili paket yöneticisi kullanılarak kurulabilmektedir. Windows için [git download](https://git-scm.com/downloads/win) bağlantısından kurulum detayları incelenebilir.

###### Temel Kavramlar

**1. Repository:** Proje dosyalarının bulunduğu yerdir (storage space). git'de repository ikiye ayrılır:
- Local Repository: Proje dosyalarının yerel makinedeki kopyalarıdır.
- Remote Repository: Projenin ana dosyalarının bulunduğu yerdir. 

**2. Commits:** Projenin belirli bir zamandaki anlık durumudur (snapshot). Her commit işlemi unique olarak bir hash bilgisine sahiptir ve yapılan değişiklerinin belirlenebildiği bir mesaj bilgisine sahiptir. Bu sayede proje geçmişi izlenebilir.

**3: Branches:** Geliştirme aşamasında ayrı bir yolu belirtir. Default branch `main` ya da `master` olarak adlandırılır. Programcı kendisi de branch'lar oluşturabilmektedir.

**4. Merge:** Bir branch'daki değişiklikleri bir araya getirme yani entegre etme işlemidir. Bu anlamda bazı conflict durumları olabilir. Merge işlemi sırasında confilict'ler çözülür.

**5. Clone:** Bir remote repository'nin yerel bir kopyasının oluşturulması işlemidir. Bu kopya tüm branch'ları ve commit geçmişini içerir. 

**6. Pull:** Remote repository'ki güncellemeleri almak ve yerel repository'ye eklemek anlamında kullanır.

**7. Push:** Yerel değişikliklerin remote repository'ye gönderilerek diğer kişilerin de kullanımına açılmasıdır. 

Bir repository'nin lokalde kopyası aşağıdaki komut ile yapılabilir:

```
git clone https://github.com/oguzkaran/JavaApp1-Aug-2025-case-study.git
```

```
git branch
```

komutu ile o repository içerisindeki tüm branch'lar listelenir. Aktif branch'n (checkout) başında `*` karakteri bulunur.  Bir branch yaratıp o branch'a checkout yapılması için `git checkout` komutu `-b` seçeneği ile kullanılmalıdır. 

```
git checkout -b feature/tcpconnection/okrn
```

Varolan bir branch'a checkout yapılması için `-b` seçeneği kullanılmaz

```
git checkout feature/tcpconnection/okrn

```

```
git status
```

komutu ile repository'nin o anki durumu incelenebilir. Yapılmış olan bir değişiklik 

```
git add .
```

komutu ile eklenebilir. Burada `.` tüm değişiklikler anlamında isterse programcı ilgili dosyaları yazarak istediği dosyaları ekleyebilir (to be staged).

```
git rm -r --cached .
```

komutu ile git'e eklenmiş olanlar geri alınabilir (rollback/to be unstaged). `-r` seçeneği `recursive` anlamına gelir.

```
git commit -m "initial commit App.java"
```


```
git push
```

komutu ile lokalden remote repository'ye aktarım yapılabilir. Burada remote repository'nin konuşlandığı server'ın konfigürasyonu yapılması gereken bazı ek işlemler olabilir. Bu git doğrudan uygulamasına ilişkin bir konu değildir. 

```
git pull
```

komutu ilgili branch'ın son durumu lokale çekilebilir.

##### BigDecimal ve BigInteger sınıfları

Bu sınıflar `java.math` paketi altından bildirilmişlerdir. `BigDecimal` sınıfı ile gerçek sayı işlemlerine ilişkin yuvarlamaların (rounding) nasıl yapılacağı belirlenebilir. Bu anlamda yuvarlama yapılmaması da belirlenebilir. `BigInteger` sınıfı long türü sınırları dışında kalan çok büyük ya da çok küçük sayılar ile de çalışılabilmesini sağlar. Bu sınıflar ile yapılan işlemler çok fazla makine komutu gerektirdiğinden maliyetli oldukları da unutulmamalıdır. Yani, bu sınıfların gerekmediği halde kullanılması gibi durumlara dikkat edilmelidir. Her ikisi de `immutable` sınıflardır. Bu sınıflar `java.lang` paketi içerisindeki `Number` sınıfından türetilmiştir.

###### BigDecimal Sınıfı

Anımsanacağı gibi  `IEEE 754` formatında yuvarlama hataları (rounding errors) söz konusu olabilmektedir. 

Aşağıdaki demo örneği çeşitli değerler ile çalıştırıp sonuçları gözlemleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var a = Console.readDouble("Input first number:");  
            var b = Console.readDouble("Input second number:");  
            var c = Console.readDouble("Input third number:");  
            var d = a + b;  
  
            Console.writeLine("a = %.20f", a);  
            Console.writeLine("b = %.20f", b);  
            Console.writeLine("c = %.20f", c);  
            Console.writeLine("d = %.20f", d);  
  
            if (c == d)  
                break;  
        }  
    }  
}
```


Yukarıdaki demo örnek için eşitlik karşılaştırması doğrudan yapılamayacağından farklı bir yaklaşım olarak aşağıdaki bir yöntem kullanılabilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var a = Console.readDouble("Input first number:");  
            var b = Console.readDouble("Input second number:");  
            var c = Console.readDouble("Input third number:");  
            var d = a + b;  
  
            Console.writeLine("a = %.20f", a);  
            Console.writeLine("b = %.20f", b);  
            Console.writeLine("c = %.20f", c);  
            Console.writeLine("d = %.20f", d);  
  
            if (Math.abs(c - d) < 0.000001)  
                break;  
        }  
    }  
}
```

 `Jupiter` test kütüphanesindeki `assertEqual` metotlarının double ve float parametreli delta değerini de alan overload'ları bulunur. 

BigDecimal sınıfının String parametreli ctor'u ile alınan yazı içsel olarak sayı biçiminde ele alınır. Bu durumda alınan yazı sayıya çevrilemeyecek bir formattaysa exception oluşur. Sınıfın pek çok ctor'u bulunur. Sınıfın sayılarla tipik işlemlerin yapılabildiği pek çok metodu bulunur. Örneğin, `add` metodu iki tane `BigDecimal`'ı toplamak için kullanılır. Bu işlemler belirlenen yuvarlama yöntemine göre yapılır. BigDecimal sınıfının equals metodu ile eşitlik karşılaştırması yapılabilir. Eşitlik karşılaştırması da yine belirlenen yuvarlama yöntemine göre yapılır.

Aşağıda demo örnekte yuvarlama hatası oluşmayacak şekilde BigDecimal nesneleri yaratılmıştır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.BigDecimal;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var a = new BigDecimal(Console.read("Input first number:"));  
            var b = new BigDecimal(Console.read("Input second number:"));  
            var c = new BigDecimal(Console.read("Input third number:"));  
            var d = a.add(b);  
  
            Console.writeLine("a = %.200f", a);  
            Console.writeLine("b = %.200f", b);  
            Console.writeLine("c = %.200f", c);  
            Console.writeLine("d = %.200f", d);  
  
            if (c.equals(d))  
                break;  
        }  
    }  
}
```

Console sınıfının readBigDecimal isimli metotları da vardır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var a = Console.readBigDecimal("Input first number:");  
            var b = Console.readBigDecimal("Input second number:");  
            var c = Console.readBigDecimal("Input third number:");  
            var d = a.add(b);  
  
            Console.writeLine("a = %.200f", a);  
            Console.writeLine("b = %.200f", b);  
            Console.writeLine("c = %.200f", c);  
            Console.writeLine("d = %.200f", d);  
  
            if (c.equals(d))  
                break;  
        }  
    }  
}
```


Bölme işlemi önemlidir. Bölme işlemi yapan metotlar için (divide metotları) sayının ondalık kısmının ne kadar olacağı ve geri kalan basamaklarının nasıl yuvarlanacağı belirlenmelidir. Bu durumda tek parametreli divide metodunda elde edilen ondalık kısmı Matematiksel olarak sonsuz ise exception oluşur.

Aşağıdaki demo örnekte exception oluşabilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.RoundingMode;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = Console.readBigDecimal("Input first number:");  
        var b = Console.readBigDecimal("Input second number:");  
        var c = a.divide(b);  
  
        Console.writeLine("a = %.200f", a);  
        Console.writeLine("b = %.200f", b);  
        Console.writeLine("c = %.10f", c);  
    }  
}
```

divide metodunun aşağıdaki overload'unda noktadan sonra kaç basamağa kadar yuvarlanacağı ve geri kalan basamakların nasıl yuvarlanacağı belirlenebilmektedir. 

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.RoundingMode;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = Console.readBigDecimal("Input first number:");  
        var b = Console.readBigDecimal("Input second number:");  
        var c = a.divide(b, 10, RoundingMode.HALF_UP);  
  
        Console.writeLine("a = %.200f", a);  
        Console.writeLine("b = %.200f", b);  
        Console.writeLine("c = %.10f", c);  
    }  
}
```


Bir BigDecimal nesnesi scale bilgisi belirtilmeden yaratıldığında default scale sıfır olarak ele alınır. 

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.RoundingMode;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = Console.readBigDecimal("Input first number:");  
        var b = Console.readBigDecimal("Input second number:");  
        var c = a.divide(b, RoundingMode.HALF_UP);  
  
        Console.writeLine("a = %.200f", a);  
        Console.writeLine("b = %.200f", b);  
        Console.writeLine("c = %.10f", c);  
    }  
}
```


BigDecimal sınıfının setScale metodu ile scale ve rounding mode bilgisi değiştirilebilir. Şüphesiz bu metot ilgili bilgileri değiştirilmiş yeni bir BigDecimal nesnesinin referansına geri döner

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.RoundingMode;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = Console.readBigDecimal("Input first number:");  
        var b = Console.readBigDecimal("Input second number:");  
  
        a = a.setScale(20, RoundingMode.HALF_UP);  
        var c = a.divide(b, RoundingMode.HALF_UP);  
          
        Console.writeLine("a = %.200f", a);  
        Console.writeLine("b = %.200f", b);  
        Console.writeLine("c = %.10f", c);  
    }  
}
```

BigDecimal sınıfının **compareTo** metodu karşılaştırma işlemi yapar. 
```java
a.compareTo(b)
```
çağrısı için geri dönüş değeri

```
-1 <=> a < b
0 <=> a == b
1 <=> a > b
```

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = Console.readBigDecimal("Input first number:");  
        var b = Console.readBigDecimal("Input second number:");  
  
        Console.writeLine(a.compareTo(b));  
    }  
}
```

BigDecimal sınıfının burada anlatılan dışında da pek çok metodu bulunmaktadır. Bu metotlar ilgili dökumanlardan incelenerek öğrenilebilir.

###### BigInteger Sınıfı

BigInteger sınıfı
$$(-2^{Integer.MAX\_VALUE}, 2^{Integer.MAX\_VALUE}) $$
aralığında tamsayı değerlerini tutabilmektedir. BigInteger sınıfının da yine pek çok metodu ve ctor'u bulunmaktadır. Yine BigInteger ile işlemlerin de yapıldığı metotlar da vardır. Yine eşitlik karşılaştırması için `equals` metodu kullanılabilmektedir.

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.BigInteger;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = new BigInteger(Console.read("Input first number"));  
        var b = new BigInteger(Console.read("Input second number"));  
        var c = a.add(b);  
  
        Console.writeLine(c);  
    }  
}
```

Aşağıdaki demo örneği inceleyiniz
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var a = Console.readBigInteger("Input first number");  
        var b = Console.readBigInteger("Input second number");  
        var c = a.add(b);  
  
        Console.writeLine(c);  
    }  
}
```


Aşağıdaki factorial metodunu inceleyiniz

```java
public static BigInteger factorial(BigInteger n)  
{  
    var result = BigInteger.ONE;  
  
    for (var i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))  
        result  = result.multiply(i);  
  
    return result;  
}
```

BigInteger sınıfında çok kullanılan bazı değerler için public static ve final olarak bildirilmiş veri elemanları bulundurulmuştur. Bu elemanların isimleri şunlardır: `ONE, TWO, TEN, ZERO`

BigInteger sınıfının `Random` parametreki ctor'ları ile rassal olarak sayı üretilebilir. numBits parametreli ctor'u ile
$$[0, 2^{numBits} - 1]$$
aralığında düzgün dağılıma (uniformly distributed) sahip rassal sayı üretilebilir.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.math.BigInteger;  
import java.util.Random;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var random = new Random();  
        var n = Console.readInt("Input count:");  
  
        while (n-- > 0) {  
            var a = new BigInteger(256, random);  
  
            if (random.nextBoolean())  
                a = a.negate();  
  
            Console.writeLine(a);  
        }  
    }  
}
```

Bu sınıfın da yine pek çok işlem yapan metodu bulunur. Bu metotlar dokümanlardan incelenebilir. Yine, `compareTo` metodu ile karşılaştırma yapılabilir.

Aşağıdaki isPrime metodunu inceleyiniz

```java
public static boolean isPrime(BigInteger a)  
{  
    if (a.compareTo(BigInteger.ONE) <= 0)  
        return false;  
  
    if (a.remainder(BigInteger.TWO).equals(BigInteger.ZERO))  
        return a.equals(BigInteger.TWO);  
  
    if (a.remainder(THREE).equals(BigInteger.ZERO))  
        return a.equals(THREE);  
  
    if (a.remainder(FIVE).equals(BigInteger.ZERO))  
        return a.equals(FIVE);  
  
    if (a.remainder(SEVEN).equals(BigInteger.ZERO))  
        return a.equals(SEVEN);  
  
    for (var i = ELEVEN; i.multiply(i).compareTo(a) <= 0; i = i.add(BigInteger.TWO))  
        if (a.remainder(i).equals(BigInteger.ZERO))  
            return false;  
  
    return true;  
}
```

Aşağıdaki demo örnekte aynı sayılar için isPrime metotlarının hızlarını gözlemleyiniz. BigInteger overload'u `org.csystem.util` kütüphanesine `2.1.0` versiyonu ile eklenmiştir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.apache.commons.lang3.time.StopWatch;  
import org.csystem.util.numeric.NumberUtil;  
  
import java.math.BigInteger;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var stopWatch = new StopWatch();  
          
        stopWatch.start();  
        Console.writeLine(NumberUtil.isPrime(710584055392819667L));  
        stopWatch.stop();  
        Console.writeLine("%f seconds", stopWatch.getNanoTime() / 1_000_000_000.);  
  
        stopWatch.reset();  
  
        stopWatch.start();  
        Console.writeLine(NumberUtil.isPrime(BigInteger.valueOf(710584055392819667L)));  
        stopWatch.stop();  
        Console.writeLine("%f seconds", stopWatch.getNanoTime() / 1_000_000_000.);  
    }  
}
```
##### Linux Dizin Yapısı

`Linux Foundation Group`, `UNIX` sistemlerindeki dizin (directory) yapısını standardize etmeye çalışmıştır. Bu standarda `File System Hierarchy Standard` denir. Buna göre bazı dizinler ve anlamları şunlardır:

`/bin:` Burada kabuk (shell) komutlarına ilişkin executable dosyalar ve çeşitli utility programlar bulunur.

`/sbin:` Burada sisteme ilişkin aşağı seviyeli executable dosyalar ve çeşitli utility programlar bulunur. Örneğin sistemin boot edilmesi için gereken dosyalar buradadır. Genel olarak `/sbin` içerisindeki dosyalar normal kullanıcılar için değil sistem yöneticileri yani root kullanıcısı içindir.

`/boot:` Bu dizinde `boot loader` ve bazı çekirdeğe (kernel) ilişkin dosyalar bulunur. Linux dağıtımlarında `lilo`, `grub` gibi bazı popüler boot loader'lar kullanılır.

`/lib:` Burada `/bin` ve `/sbin` içerisinde bulunan programların kullandığı kütüphaneler bulunur.

`/dev:` Burada aygıt sürücülere (device driver) ilişkin dosyalar bulunmaktadır.

 `/etc:` Bu dizin "etcetera" sözcüğünün kısaltmasından oluşturulmuştur. İlk zamanlarda bu dizin diğer dizinlerde olmayacak şeyleri içeriyordu. Sonraki yıllarda burada olanlar da gittikçe belirgin olmaya başlamıştır. Bu dizinde genel olarak çeşitli konfigürasyon bilgileri tutulur. Bu nedenle etc ismi artık **editable text configuration** kısaltması olarak kullanılmaktadır

`/home:` Burada kullanıcılar için ayrılan dizinler tutulur. Normal olarak her kullanıcın kullanıcı ismine ilişkin bir dizini vardır.

`/mnt:` Kullanıcıların mount işlemi için kullanabilecekleri genel bir dizindir.

`/root:` Bu dizin root kullanıcısı için home dizini görevindedir.

`/media:` Bu dizin çıkarılabilir aygıtların (CDROM, Flash EPROM vb.) mount edildiği dizindir.

`/usr:` Burada kullanıcıların yerleştirdiği ya da install ettiği tüm yazılımlara ilişkin executable dosyalar, kütüphaneler ve bazı geliştirme araçları için gereken dosyalar bulunur. `/usr/bin` dizininde genel olarak dağıtıma ilişkin utility programlar bulunur. `/usr/local` lokal makinedeki programlar için düşünülmüştür.

`/var:` Bu dizin log dosyaları gibi sistemin çalışması sırasında sürekli güncellenen dosyaların tutulduğu bir dizindir. Bu dizinin de pek çok alt dizini vardır

`/sys:` Aygıt sürücülerin ve çekirdeğe ilişkin bazı dosyaların bulunduğu dizindir
 
`/tmp:` Geçici dosyalar için bulundurulan bir dizindir. Genellikle sistem kapatılırken silinmektedir

##### Sisteme Giriş (Login)

`UNIX` sistemlerinde her kullanıcıya bir username ve bir password verilir. Bir kullanıcı username ve password ile sisteme giriş (login) yapar. Sisteme giriş yapmak genellikle 3 yoldan yapılabilir:

1. **Text tabanlı bir terminal program ile:** Eğer sistemde bir Graphical User Interface (GUI) (tipik olarak Xwindow) yoksa bu yoldan giriş yapılır. Genellikle sunucu (server) sistemlere bu şekilde erişilir.

2. **GUI ile:** Eğer sistemde bir GUI varsa bunlarla giriş yapılabilir.

3. **Uzak bağlantı (remote) yoluyla:** Uzak bağlantı yoluyla erişim tipik olarak `ssh` ve `telnet` gibi bir protokolle text tabanlı olarak, VNC gibi protokol ile de GUI olarak yapılabilmektedir. Örneğin ssh ile bağlatı şu şekilde yapılabilir:

```
ssh oguz@192.168.1.123
```

Burada tipik olarak `oguz` kullanıcı ismi ve `@` işaretinden sonra yazılan bilgi ise uzak makinenin adres bilgisidir.
##### UNIX/Linux Sistemlerinde Yeni Kullanıcıların ve Grupların Yaratılması:

UNIX sistemlerinin çoğunda kullanıcılara ilişkin bilgiler text dosyalarda tutulur. Bu text dosyanın her satırı bir kullanıcıya ilişkin bilgilerden oluşur. `Linux` ve `BSD` sistemlerinde `/etc/passwd` dosyası kullanıcı bilgilerini tutan bir dosyadır. Her kullanıcının bilgisi burada tutulur. Bu dosya normal kullanıcılar için **read only** durumdadır. Yani bu dosyanın içeriğini normal kullanıcılar görüntüleyebilir ancak dosyada değişiklik yapamaz. Bir kullanıcıya ilişkin bilgiler `:` ile ayrılır ve toplam 7 tane sütun bulunur:

```
deniz:x:1001:1002:Deniz Karan,605,,,Junior:/home/deniz:/bin/bash
```

Buradaki 7 sütunun anlamları kabaca şu şekildedir:

1. Kullancı ismi

2. Kullanıcının password'üne ilişkin `encrypted` bir bilgidir. Eskiden kullanıcılar şifrelenmiş parola bilgileri bu dosyada saklanırdı. Bu anlamda şifrelenmiş bilgilerin şifrelemesi tek yönlü (one way) yapıldığı için bu bilginin elde edilmesinde bir sakınca görülmemiştir. Zamanla bu bilginin de görülmesi istenmediğinden `/etc/passwd` dosyasında `x` olarak yazılmaya başlandı. Bu bilgi ayrı bir dosyada saklanır duruma geldi. Bu bilgi tipik olarak `/etc/shodow` dosyası içerisinde saklanır ve bu dosyanın içeriği normal kullanıcılar tarafından okunamaz ve değiştirilemez.

3. Kullanıcı id'si her kullanıcı ismine karşılık verilir. İki kullanıcının id'si aynı olamaz. Tipik olarak `root` kullanıcısının id bilgisi sıfırdır.

4. Grup id'si her gruba karşılık verilir. Kullanıcıların ait olduğu grupların bilgileri de `/etc/group` dosyasında tutulur. Her yeni kullanıcı için default olarak ayrı bir grup oluşturulur

5. Kullanıcıya ilişkin bilgiler bulunur. Bilgiler virgül ile ayrılır. Bilgiler boş geçilebilir ancak genel olarak virgüller yine bulundurulur.

6. Kullanıcı dizinine ilişkin yol ifadesi belirtilir.

7. Kullanıcının sisteme ilk giriş yaptığında çalıştırılacak terminal program belirtilir. Buradaki program default olarak çalıştırılır. Linux sistemlerinde default olarak `bash` (Bourne Again Shell) kullanılır.

Öyleyse kullanıcı eklemek için tipik olarak `/etc/passwd` dosyasına uygun satırı eklemek gerekir. Tabi bu durumda kullanıcı dizini, password ve grup id gibi bilgilerin de oluşturulması gerekir. Bu işlemleri manuel olarak yapmak oldukça zahmetli olabilmektedir. Bu sebeple `adduser` isimli bir komut vardır. Ancak bu komut pek user friendly değildir. Bu sebeple daha user friendly olan `useradd` isimli ayrı bir komut vardır. User oluşturabilmek için root yetkisine sahip olmak gerekir. root yetkisine sahip olan bir user'a `sudoer` denir. sudoer olan bir user ile login olunduğunda `sudo` (super user do) isimli komut ile root şifresi de girilerek root yetkisi elde edilebilir. Eğer user sudoer değilse kesinlikle root yetkisine sahip işlemleri yapamaz.

**Anahtar Notlar:** Bazı lightweight sistemlerde kurulum sırasında root kullanıcısına ilişkin bilgiler sorulmaz. Tipik olarak `Ubuntu` ve `Mint` dağıtımları bu şekildedir. Bu sistemler kurulurken belirlenen ilk user sudoer yapılır ve parolası aynı zamanda root kullanıcısının da parolası olur.

`useradd` için örnek bir kullanım aşağıdaki gibidir:

```
sudo useradd -m bekir -s /bin/bash -d /home/bekir
```

Burada bekir isimli bir kullanıcı yaratılmış, shell olarak /bin/bash verilmiş ve kullanıcı dizini olarak da /home/bekir olarak verilmiştir. Kullanıcı eklendikten sonra `passwd` programı ile kullanıcının şifresi de belirlenebilir. Şüphesiz `passwd` programı da `root` olarak çalıştırılmalıdır.

```
sudo passwd bekir
```

Benzer şekilde bu sistemlerde grup da oluşturulabilir. Bunun için de `addgroup` ve daha user friendly olan `groupadd` programları kullanılabilir. Grup oluşturma ve kullanıcıların gruplara eklenmesi gibi kavramlar projeler içerisinde kullanılacaktır.

##### İşletim Sistemlerinin Dosya Sistemleri

İçerisinde bilgilerin bulunduğu **ikincil belleklerdeki (secondary memory)** alanlara dosya (file) denir. Bu bilgiler **sektör (sector)** denilen okunabilen ve yazılabilen en küçük birimlerde tutulur. İşletim sistemleri bu organize edilmiş bilgileri dışarıya dosya kavramı olarak gösterirler. Aslında dosya mantıksal bir kavramdır. İşletim sistemlerinin bu organizasyonu yapan alt birimine **dosya sistemi (file system)** denir. Dosya sistemi Unix/Linux sistemlerinin adeta kalbi biçimindedir. Bu sistemlerde pek çok kavram dosya gibi ele alınır. Örneğin klasik dosyalar (regular file), dizinler (directories), borular (pipes), soketler (sockets) vb.

Bu sistemlerde bir çeşit `polymorphism` uygulanmıştır. Örneğin bir dosyaya yazma yaptığımızda dosyanın türüne göre yazma işlemi gerçekleşir. Yani gerçek anlamda bir dosyaya yazma olmayabilir. Polymorphic yaklaşım dolayısıyla Linux sistemlerinin dosya sistemine **sanal dosya sistemi (virtual file system)** de denilmektedir.
##### Unix/Linux Sistemlerinde Dosya Erişim Hakları

**Dosyaya erişim uygulamalar tarafından yapılır.**  Örneğin bir dosyanın içeriğini cat programı ile stdout'a göndermek istediğimizde `cat` programı dosyayı okumak için açar ve okuma işlemlerini yapar. Bu durumda cat programının bu dosyayı okumak için yetkisinin olması gerekir. İşletim sistemlerinde çalışan bir programa process denir. Unix/Linux sistemlerinde process'lere ilişkin bilgiler `ps` isimli bir komut (program) ile elde edilebilir.

Örneğin `ps -ef` biçiminde bir çalıştırma ile process'lere ilişkin detay bilgiler elde edilebilir. Bu sistemlerde her process'lerin id değerleri vardır. Bu id değeri sistem genelinde tekil (unique) olarak belirlenir. Process için ayrıca çalışma zamanında değişebilen (detayları önemsiz) `effective user id` ve `effective group id` denilen id değerleri de vardır. Bunun dışında `real user id` ve `real group id` denilen id değerleri de bulunur. Bu sistemlerde bir dosyanın da bir user id'si ve bir group id'si bulunur. Dosyalar için effective veya gerçek id gibi kavramlar yoktur. Bir dosyanın erişim hakları, user ve group id vb bilgileri `ls` isimli bir program ile elde dilebilir. Örneğin `ls -l` biçiminde çalıştırıldığında bulununan directory'nin içerisindeki tüm dosyalar çeşitli bilgileri ile birlikte listelenir:

```
crw-r--r--  1 root      root     10, 235 Aug 24 14:39 autofs
drwxr-xr-x  2 root      root         420 Aug 30 13:11 block
drwxr-xr-x  2 root      root          80 Jul 26 20:01 bsg
crw-rw----  1 root      disk     10, 234 Aug 24 14:39 btrfs-control
drwxr-xr-x  3 root      root          60 Jul 26 20:01 bus
lrwxrwxrwx  1 root      root           3 Jul 26 20:01 cdrom -> sr0
drwxr-xr-x  2 root      root        3900 Aug 30 13:36 char
crw--w----  1 root      tty       5,   1 Aug 24 14:39 console
lrwxrwxrwx  1 root      root          11 Jul 26 20:01 core -> /proc/kcore
crw-------  1 root      root     10, 123 Aug 24 14:39 cpu_dma_latency
crw-------  1 root      root     10, 203 Jul 26 20:01 cuse
drwxr-xr-x  9 root      root         180 Aug 24 14:39 disk
drwxr-xr-x  2 root      root          80 Jan  1  1970 dma_heap
drwxr-xr-x  3 root      root         100 Jul 26 20:01 dri
crw-------  1 root      root     10, 125 Aug 24 14:39 ecryptfs
crw-rw----  1 root      video    29,   0 Aug 24 14:39 fb0
lrwxrwxrwx  1 root      root          13 Jul 26 20:01 fd -> /proc/self/fd
crw-rw-rw-  1 root      root      1,   7 Aug 24 14:39 full
crw-rw-rw-  1 root      root     10, 229 Aug 30 13:13 fuse
crw-------  1 root      root    237,   0 Aug 24 14:57 hidraw0
crw-------  1 root      root    237,   1 Aug 24 14:57 hidraw1
crw-------  1 root      root    237,   2 Aug 24 14:57 hidraw2

```


Burada `3.` ve `4.` sütunlar sırasıyla dosyanın user id'si ve grup id'sini belirtir. Aslında burada id'lerin değeri doğrudan yazmaz. Her kullanıcı ismine ve grup ismine karşılık birer id değeri verildiğini anımsayınız. **Dosyanın erişim hakları aslında dosya ile hangi işlemlerin yapılıp yapılmayacağını belirtir.** Bu anlamda yukarıdaki birinci sütunda dosyanın türü ve erişim hakları bilgisi bulunur. En soldaki bilgi dosyanın türünü belirtir. Bu bilgi `-` ise dosya norma (klasik) bir dosyadır `(regular file)`, `d` ise bir `dizin` belirtir, `p` ile bir `pipe` belirtir, `s` ise bir `soket` belirtir, `c` ise bir `chracter device` belirtir, `b` ise bir `block device` belirtir, `l` ise `symbolic link` belirtir. Burada normal dosya ve dizinler için erişim haklarını inceleyeceğiz. Birinci sütundaki dosya türünden sonra gelen 9 karakter üçerli üç gruba ayrılır. Bu üçerli gruplar `rwx` biçiminde oluşturulur. Eğer dosya için okuma hakkı varsa `r`, yazma hakkı varsa `w` ve çalıştırma (execute) hakkı varsa `x` yazılır. Hakkın olmaması durumunda `-` ile belirtilir. Buradaki ilk üçlü sahiplik `owner`, ikinci üçlü grup `group`, üçüncü üçlü ise diğerinin `others` haklarını temsil eder. Normal bir dosya için okuma hakkı dosyanın verilerini okuma hakkı anlamındadır. Örneğin `cat` process'inin bir dosyanın içeriğine erişmesi için  dosyanın `r` hakkına sahip olması gerekir. Dosya bir dizinse `r` hakkı o dizin içerisindeki dosya bilgilerinin elde edilmesi anlamındadır. Örneğin `ls` programının ilgili dizindeki dosya bilgilerini elde etmesi için o dizinin `ls` için `r` hakkı olması gerekir. Normal bir dosya için `w` hakkı dosyanın verileri üzerinde değişiklik yapma hakkıdır. Örneğin bir process'in bir dosyaya veri eklemesi için `w` hakkı olması gerekir. Bir dizin için `w` hakkı o dizin içerisinde olan bir dosyanın silinmesi veya yeni bir dosya eklenebilmesi hakkıdır. Normal bir dosya için `x` hakkı o dosyanın çalıştırılabilmesi (execute) hakkıdır. İşletim sistemi düzeyinde bir programın çalıştırılabilmesi için `x` hakkına sahip olması gerekir. Bir dosyaya erişirken kullanılan yol ifadesinde bulunan dizinlerin x hakkı yoksa o dizinlerden geçilemez. Örneğin yol ifadesi `/a/b/c/test.txt` biçimindeyse burada `test.txt` dosyasına erişmek için root, a, b ve c dizinlerinin x hakkına sahip olması gerekir. Aksi durumda erişilemez. Bu durumda bir dizin için r ve w hakkı olmayabilir. Ancak o dizinden geçiş yapılabilir.

Bu erişimler bir process için şu şekilde bakılarak elde edilir. Bir process bir dosyaya erişmek istediğinde process'in effective user id'si ile erişmek istediği dosyanın user id'si aynı ise dosyanın sahiplik hakları söz konusu olur, değilse process'in effective group id'si erişmek istediği dosyanın group id'si ile aynı ise grup hakları söz konusu olur, değilse diğerleri için olan hakları söz konusu olur.

Bir dosyanın erişim hakları tipik olarak `chmod` isimli bir program kullanılarak değiştirilebilir. Bu program kullanıcıya ait olmayan bir dosya için `root` olarak çalıştırılmalıdır. `chmod` komutu oldukça kapsamlıdır. `+w`, `+r`, `+x` seçenekleri ile ilgili erişim hakları tüm 3'erli gruplara verilebilir. Benzer şekilde `-w`, `-r`, `-x` seçeneği ile haklar silinebilir. Bu komutun önemli bir kullanımı da ilgili hakların `octal` sistemde değer verilerek kullanılmasıdır. Her bir 3'lü octal sistemde bir değer ile belirlenir. `chmod` komutuna sıfır ile birlikte 3 tane octal digit yazılarak erişim hakları belirlenir. Örneğin `test` isimli dosyanın erişim hakkının `rwxr-x--x` şekilde olması için `chmod` komutu şu şekilde kullanılabilir:

```
chmod 0751 test
```

Burada pek çok sistemde octal sayının başındaki sıfır yazılmayabilir:

```
chmod 751 test
```

**Anahtar Notlar:** Burada anlatılanların dışında pek çok detay bulunmaktadır. Programcı açısından tipik kullanımlar ele alınmıştır.

##### stdin, stdout ve stderr Dosyaları

Bir program çalıştırıldığında 3 tane dosya açılır: **Standard Input (stdin), Standard Output (stdout), Standard Error (stderr).** 

Java'da stdin, stdout ve stderr sırasıyla `System` sınıfının `in`, `out` ve `err` static referans veri elemanları ile temsil edilir. `in`, `InputStream` türünden, `out` ve `err`'de `PrinStream` türünden referans veri elemanlarıdır. Masaüstü işletim sistemlerinin hemen hepsinde default olarak `stdin` klavyeye, `stdout` ekrana, `stderr`'de `stout`'a yönlendirilmiştir. Bu dosyalar ayrıca program çalıştırılırken de yeniden yönlendirilebilir **(redirection)**. Hatta programlama yöntemiyle de yönlendirme yapılabilmektedir. Programlama yöntemiyle yapılabilen yönlendirme burada ele alınmayacaktır. Bu dosyalar yönlendirildiğinde artık bu dosyalar ile işlem yapan metotlar ona göre ilgili işlemini yaparlar. Örneğin `stdout` başka bir dosyaya yönlendirildiğinde* `System.out.println` metodu yazma işlemini yönlendirilen dosyaya yapar. Program çalıştırılırken yönlendirme işlemi **stdout** ve **stderr** için `>` ile, **stdin** için ise `<` karakteri kullanılarak yapılır. Bu kullanım biçimi modern işletim sistemlerinin bir çoğunda aynıdır. **stdout** için `>` biçiminde kullanılır. Bazı sistemlerde desteklenmeyebileceğinden, **stderr** için de `2>` biçiminde kullanılmalıdır. Örneğin bir program aşağıdaki gibi çalıştırılmış olsun:

```
java -jar .\Sample-1.0.0.jar < input.txt > output.txt 2> error.txt
```

Burada `stdin` `input.txt` dosyasına, `stdout` `output.txt` dosyasına, `stderr` de `error.txt` dosyasına yönlendirilmiştir.

**Peki stderr neden kullanılır?**

Tipik olarak uygulamalar çeşitli hata durumlarına karşılık mesajlarını `stderr`'ye basma eğilimindedir. Bu bir convention olarak düşünülebilir. Bu durumda örneğin, program çalıştırıldığında hatalı durumlara ilişkin mesajların takibi de yapılabilir.

Bir programın `stdout`'u başka bir programın `stdin`'i olabilir. Bu işlem bir çok işletim sisteminde aşağıdaki gibi boru `pipe` haberleşmesi kullanılarak yapılabilir:

```
java -jar RandomTextGeneratorApp-1.0.0.jar | java -jar LineReaderApp-1.0.0.jar
```

Burada `RandomNumberGenerator-11.0.0.jar` uygulamasının `stdout`'u, `NumberReader-11.0.0.jar` uygulamasının `stdin`'ine yönlendirilmiştir.

`003-DemoRedirectionApps` içerisindeki uygulamaları inceleyiniz.

##### Tarih Zaman İşlemleri

Programlamada tarih-zaman işlemleri oldukça önemlidir. JavaSE'de de tarih zaman işlemlerini yapan hazır sınıflar bulunur. Tarihsel süreç içerisinde JavaSE'de tarih-zaman işlemlerine ilişkin UDT'lerde ciddi değişiklikler yapılmıştır. Aslında tarih zaman işlemlerine ilişkin UDT'lerin etkin bir biçimde kullanımı Java 8 ile birlikte olmuştur.  Hatta Java'nın ilk yıllarında eklenen tarih-zaman sınıfları bir takım işlemleri doğru olarak yapamıyorlardı. Bu anlamda bu sınıfların pek çok elemanı şu an`deprecated` durumdadır. Bu sınıflardan sonra eklenen tarih-zamana ilişkin sınıflar işlemleri doğru olarak yapsalar da yaklaşım açısından problemlidir. Bu anlamda bu sınıfların elemanları `deprecated` olmamıştır. Ancak `Java 8` ile birlikte artık kullanımı gerekmemekte, hatta tavsiye edilmemektedir. `Java 8` *ile birlikte eklenen tarih-zaman türleri ile tarih-zaman işlemleri hem doğru hem de daha etkin bir biçimde yapılır duruma gelmiştir. Buna göre bir java programcısı için* `Java 8+` *ile geliştirilen bir projede (ya da kütüphanede) yeni nesil sınıfların kullanılması tercih edilmelidir. Programlamda tarih-zaman türlerine ilişkin genel olarak iki yaklaşım söz konusudur:*

- Tarih, zaman ve tarih-zaman olarak türleri **ayırmak**

- Tarih, zaman ve tarih-zaman olarak türleri **ayırmamak**

Bunlar birer yaklaşımdır ve iyi ya da kötü anlamda düşünülmemelidir. Dile ve teknolojiye göre programcı öğrenir ve ona göre kullanır.


`Java 1.0` *ile eklenen tarih-zaman işlemlerini yapan* `java.util.Date` *sınıfının pek çok elemanı* `Java 1.1` *ile birlikte* `deprecated` olmuştur. Bu sınıf ileride ele alacağımız veritabanı işlemlerinde kullanılan bazı sınıflara taban sınıf olduğundan belirli ölçüde bilinmesi gerekir. Aslında bu sınıfın deprecated olan metotları Java1.1 ile birlikte doğru çalışmamaktadır. Java 1.1 ile birlikte `Calendar` *ve ondan türetilmiş olan* `GregorianCalendar` isimli sınıflar tarih-zaman işlemlerinde kullanılmak üzere eklenmiştir. Bu sınıfların genel olarak tasarımları kötüdür. Bu 3 sınıf (`Date`, `Calendar` ve `GregorianCalendar`) tarih ve zaman kavramlarını ayırmaz. Yani tarih-zaman bir arada tutulur. Yalnızca tarih veya yalnızca zaman için programcı bu sınıfları ona göre kullanır. `Java 8` ile eklenen yeni nesil tarih-zaman türlerinde tarih, zaman ve tarih-zaman kavramları ayrı türler olarak temsil edilmiştir. Java 8 ile eklenen tarih-zaman sınıfları immutable'dır. `Date` ve `Calendar` *(dolayısıyla* `GregorianCalendar`) sınıfları **immutable** değildir.

`java.util.Date` sınıfını default ctor'u ile nesne yaratıldığında çalışılan sistemdeki tarih zaman bilgisi tutan `Date` nesnesi elde edilir. Bu sınıfın toString metodu tarih zamn bilgisinin belirli formattaki yazı karşılığına geri döner. Bu formate ilişkin detaylar gerekirse dokümanlardan incelenebilir.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Date;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = new Date();  
  
        Console.writeLine(now);  
    }  
}
```

Date sınıfının getTime metodu `1 Ocak 1970 00:00:00.0 GMT` zamanından itibaren geçen milisaniye değerine geri döner. Ayrıca Date sınıfının long parametreli ctor'u aldığı milisaniye değerine ilişkin Date nesnesini yaratmakta kullanılır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Date;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = new Date();  
  
        Console.writeLine(now);  
        var ms = now.getTime();  
        Console.writeLine("Milliseconds:%d", ms);  
        var date = new Date(ms);  
  
        Console.writeLine(date);  
    }  
}
```

Calendar sınıfının getInstance metodunun parametresiz overload'u ile çalışılan sistemdeki o anki zaman elde edilebilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Calendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = Calendar.getInstance();  
  
        Console.writeLine(now);  
    }  
}
```

GregorianCalendar sınıfının default ctor'u ile çalışılan sistemdeki o anki zaman elde edilebilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.GregorianCalendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = new GregorianCalendar();  
  
        Console.writeLine(now);  
    }  
}
```

`Calendar` sınıfının **getter/accessor** ve **setter/mutator** elemanları (metotları) alışık olduğumuz şekilde her bileşen için ayrı olarak tasarlanmamıştır. set ve get metotları ilgili eleman ile işlem yapmak için o elemana **(field)** karşılık `int` türden değeri parametre olarak alırlar. Bu değerler `public static final` *olarak* `Calendar` sınıfında bildirilmiştir. Yani buradaki problem bu değerlerin kaç olduğunun anımsanması değil, bu metotların tasarımıdır. NYPT açısından bu tasarım çok kullanışlı değildir. `Calendar` sınıfı için ay bilgisi `[0, 11]` aralığındadır.

Aşağıdaki demo örneği inceleyiniz

 ```java
 package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.GregorianCalendar;  
import java.util.Calendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = new GregorianCalendar();  
  
        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d", now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1,  
                now.get(Calendar.YEAR), now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));  
    }  
}
 ```

`GregorianCalendar` sınıfının tarih-zaman bileşenlerinin verilebildiği çeşitli ctor'ları vardır. Bu ctor'larda verilmeyen değerler sıfır alınır. Yani örneğin sadece yıl, ay ve gün ile yaratılan bir nesne için zaman geceyarısını (midnight) gösterir.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.GregorianCalendar;  
import java.util.Calendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = new GregorianCalendar(2025, Calendar.NOVEMBER, 4);  
  
        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d", now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1,  
                now.get(Calendar.YEAR), now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));  
    }  
}
```


`Calendar` sınıfının `getTimeInMillis` metodu **Epoch Time (01.01.1970 geceyarısı)** ile ilgili zaman arasındaki milisaniye sayısına geri döner. Bu değer `UTC` (Universal Time Clock) olarak elde edilir. Aşağıdaki demo örnekte yaşlar hesaplanmıştır.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Calendar;  
import java.util.GregorianCalendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var staff1 = new Staff("Oğuz Karan", "12345678924", 10, 9, 1976);  
        var staff2 = new Staff("Atilla Karan", "12345678926", 22, 3, 1945);  
  
        Console.writeLine("Name:%s, Age:%f", staff1.getName(), staff1.getAge());  
        Console.writeLine("Name:%s, Age:%f", staff2.getName(), staff2.getAge());  
    }  
}  
  
class Staff {  
    private static final double DIVIDER = 1000. * 60 * 60 * 24 * 365;  
    private String m_name;  
    private String m_citizenId;  
    private Calendar m_birthDate;  
  
    public Staff(String name, String citizenId, int day, int month, int year)  
    {  
        m_name = name;  
        m_citizenId = citizenId;  
        m_birthDate = new GregorianCalendar(year, month - 1, day);  
    }  
  
    //...  
  
    public String getName()  
    {  
        return m_name;  
    }  
  
    public double getAge()  
    {  
        var now = new GregorianCalendar();  
  
        return (now.getTimeInMillis() - m_birthDate.getTimeInMillis()) / DIVIDER;  
    }  
}
```

Calendar (dolayısıyla `GregorianCalendar`) sınıfı tarih-zamana yönelik bileşenlerinin sınır değerlerini kontrol etmez. İlgili değerlere göre uygun tarihi hesaplar. Bu durumda tarih-zamanın geçersizlik durumu gerektiğinde programcı tarafından kontrol edilmelidir. Bu da `Calendar` sınıfının tasarım problemlerinden biridir. Aşağıdaki demo örneği inceleyiniz.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.GregorianCalendar;  
import java.util.Calendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = new GregorianCalendar(2025, -26, 567, 345, -78, -906);
  
        Console.writeLine("%02d/%02d/%04d %02d:%02d:%02d", now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1,  
                now.get(Calendar.YEAR), now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));  
    }  
}
```

Calendar sınıfının `before` ve after metotları sırasıyşa çağıran referansa ilişkin tarihin, parametresi ile aldığı tarihten önce ya da sonra olup olmadığını test eder. Duruma göre boolean türüne geri döner. Calendar sınıfının `compareTo` metodu iki tarih karşılaştırması yapılabilir. Bu metot

```java
r = a.compareTo(b)
```

çağrısı için:

1. a tarihi b tarihinden önce geliyorsa <=> r < 0
2. a tarihi b tarihinden sonra geliyorsa <=> r > 0
3. a tarihi b tarihi ile aynıysa <=> r == 0

biçiminde çalışır.

**Sınıf Çalışması:** Klavyeden gün, ay ve yıl bilgileri ile alınan doğum tarihine göre aşağıdaki mesajlardan birini yazdıran programı yazınız

1. Doğum günü henüz gelmemişse, `Doğum gününüz şimdiden kutlu olsun. Yaşınız:49.13`
2. Doğum günü geçmişse, `Geçmiş doğum gününüz kutlu olsun. Yaşınız:49.13`
3. O gün doğum günü ise, `Doğum gününüz kutlu olsun. Yaşınız:49`


**Çözüm - 1:**
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Calendar;  
import java.util.GregorianCalendar;  
  
class Application {  
    private static void printStatus(int day, int month, int year)  
    {  
        var now = new GregorianCalendar();  
        var today = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));  
        var birthDate = new GregorianCalendar(year, month - 1, day);  
        var birthDay = new GregorianCalendar(today.get(GregorianCalendar.YEAR), month - 1, day);  
        var age = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365);  
  
        if (today.before(birthDay))  
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);  
        else if (today.after(birthDay))  
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);  
        else  
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);  
    }  
  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Gün?");  
        var month = Console.readInt("Ay?");  
        var year = Console.readInt("Yıl?");  
  
        printStatus(day, month, year);  
    }  
}
```

**Çözüm - 2:**
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Calendar;  
import java.util.GregorianCalendar;  
  
class Application {  
    private static void printStatus(int day, int month, int year)  
    {  
        var now = new GregorianCalendar();  
        var today = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));  
        var birthDate = new GregorianCalendar(year, month - 1, day);  
        var birthDay = new GregorianCalendar(today.get(GregorianCalendar.YEAR), month - 1, day);  
        var age = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365);  
  
        var res = today.compareTo(birthDay);  
  
        if (res < 0)  
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);  
        else if (res > 0)  
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);  
        else  
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);  
    }  
  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Gün?");  
        var month = Console.readInt("Ay?");  
        var year = Console.readInt("Yıl?");  
  
        printStatus(day, month, year);  
    }  
}
```

Calendar sınıfının `getActualMaximum` ve `getActualMinimum` metotları ile verilen field değerine ilişkin en büyük değer ve en küçük değer elde edilebilir

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.util.Calendar;  
import java.util.GregorianCalendar;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var expiryMonth = Console.readInt("Input expiry month:");  
            var expiryYear = Console.readInt("Input expiry year:");  
            var expiryDate = new GregorianCalendar(expiryYear, expiryMonth - 1, 1);  
  
            expiryDate.set(Calendar.DAY_OF_MONTH, expiryDate.getActualMaximum(Calendar.DAY_OF_MONTH));  
  
            Console.writeLine(expiryDate);  
              
            Console.writeLine(new GregorianCalendar().after(expiryDate) ? "Card expired" : "Card is available");  
        }  
    }  
}
```

**Sınıf Çalışması:** Klavyeden gün, ay ve yıl bilgileri ile alınan doğum tarihine göre aşağıdaki mesajlardan birini yazdıran programı yazınız

1. Doğum günü henüz gelmemişse, `Doğum gününüz şimdiden kutlu olsun. Yaşınız:49.13`
2. Doğum günü geçmişse, `Geçmiş doğum gününüz kutlu olsun. Yaşınız:49.13`
3. O gün doğum günü ise, `Doğum gününüz kutlu olsun. Yaşınız:49`


**Çözüm - 1:**
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.datetime.DateTime;  
  
class Application {  
    private static void printStatus(int day, int month, int year)  
    {  
        var today = DateTime.today();  
        var birthDate = DateTime.of(day, month, year);  
        var birthDay = birthDate.withYear(today.getYear());  
        var age = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365);  
  
        if (today.isBefore(birthDay))  
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);  
        else if (today.isAfter(birthDay))  
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);  
        else  
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);  
    }  
  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Gün?");  
        var month = Console.readInt("Ay?");  
        var year = Console.readInt("Yıl?");  
  
        printStatus(day, month, year);  
    }  
}
```

**Çözüm - 2:**
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.datetime.DateTime;  
  
class Application {  
    private static void printStatus(int day, int month, int year)  
    {  
        var today = DateTime.today();  
        var birthDate = DateTime.of(day, month, year);  
        var birthDay = birthDate.withYear(today.getYear());  
        var age = (today.getTimeInMillis() - birthDate.getTimeInMillis()) / (1000. * 60 * 60 * 24 * 365);  
  
        var res = today.compareTo(birthDay);  
  
        if (res < 0)  
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);  
        else if (res > 0)  
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);  
        else  
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);  
    }  
  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Gün?");  
        var month = Console.readInt("Ay?");  
        var year = Console.readInt("Yıl?");  
  
        printStatus(day, month, year);  
    }  
}
```

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.datetime.DateTime;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var expiryMonth = Console.readInt("Input expiry month:");  
            var expiryYear = Console.readInt("Input expiry year:");  
            var expiryDate = DateTime.of(1, expiryMonth, expiryYear);  
  
            expiryDate = expiryDate.withDay(expiryDate.getEndOfMonth());  
  
            Console.writeLine(expiryDate);  
  
            Console.writeLine(DateTime.now().isAfter(expiryDate) ? "Card expired" : "Card is available");  
        }  
    }  
}
```

`Java 8` ile eklenen `LocalDate`, `LocalTime` ve `LocalDateTime` sınıflarının ctor'ları **private** olarak bildirilmiştir. Bu sınıflar ile nesne yaratmak için `of` **factory** metotları kullanılır. `LocalDate` ve `LocalDateTime` sınıfları için ay bilgisi 1 değerinden başlayacak şekilde verilir. Ayrıca yine bu sınıflarla birlikte eklenen `Month` enum sınıfı ile de ay bilgisi verilebilir veya elde edilebilir. Bu sınıfların ilgili tarih-zaman değerlerine ilişkin **accessor/getter** metotları ayrıdır. Bu sınıflar immutable olduğundan veri elemanlarının değiştirilmesi ile ilgili işlem yapan metotlar yeni bir nesne referansına dönerler. Bu sınıflar nano-saniye mertebesinde değer tutabilirler. Bu sınıfların `toString` *metotları* `ISO-8601` standardına göre formatlı bir yazıya geri döner. 

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.LocalDateTime;  
import java.time.LocalTime;  
import java.time.Month;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var date = LocalDate.of(2025, Month.NOVEMBER, 6);  
        var time = LocalTime.of(20, 13, 45, 567);  
        var dateTime1 = LocalDateTime.of(2025, Month.NOVEMBER, 6, 20, 13, 45, 567);  
        var dateTime2 = LocalDateTime.of(date, time);  
  
        Console.writeLine(date);  
        Console.writeLine(time);  
        Console.writeLine(dateTime1);  
        Console.writeLine(dateTime2);  
    }  
}
```

Bu sınıfların `now` metotları çalışılan sistemin o anki tarih-zaman bilgisine ilişkin nesnenin referansına döner. Bu sınıfların `plusXXX` ve `minusXXX` metotları ile ilgili zamana çeşitli birimlerde (gün, ay yıl, saat vb) değerler eklenebilir ya da çıkartılabilir. 

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.LocalDateTime;  
import java.time.LocalTime;  
import java.time.Month;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = LocalDateTime.now();  
        var today = LocalDate.now();  
        var currentTime = LocalTime.now();  
  
        Console.writeLine(now);  
        Console.writeLine(today);  
        Console.writeLine(currentTime);  
  
        var dateTime = now.plusWeeks(3).plusDays(1).minusHours(4);  
        var date = today.minusMonths(2).minusDays(2);  
        var time = currentTime.minusHours(3).plusSeconds(75);  
  
        Console.writeLine(dateTime);  
        Console.writeLine(date);  
        Console.writeLine(time);  
    }  
}
```

Yine `withXXX` metotları ile herhangi bir bileşenin değişmiş olduğu yeni nesne referansı elde edilebilir. 

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var today = LocalDate.now();  
  
        Console.writeLine(today);  
  
        var date = today.withYear(2024).withDayOfMonth(10);  
  
        Console.writeLine(date);  
    }  
}
```

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.Month;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var date = LocalDate.of(2025, Month.MARCH, 2);  
  
        Console.writeLine(date.getDayOfWeek());  
        date = date.withYear(2024).withDayOfYear(61);  
        Console.writeLine(date);  
    }  
}
```

Bu sınıflar tarih-zaman geçerlilik kontrolünü yaparlar ve herhangi bir geçersiz tarih-zaman durumunda `DateTimeException` nesnesi fırlatırlar. 


```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.DateTimeException;  
import java.time.LocalDate;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Input day:");  
        var month = Console.readInt("Input month:");  
        var year = Console.readInt("Input year:");  
  
        try {  
            var date = LocalDate.of(year, month, day);  
  
            Console.writeLine(date);  
        }  
        catch (DateTimeException e) {  
            Console.Error.writeLine("Invalid date format:%s", e.getMessage());  
        }  
    }  
}
```

`LocalDate` sınıfının `atTime` ve `LocalTime` sınıfının `atDate` metotları ilgili bilgilerden oluşan `LocalDateTime` nesnesinin referansına geri dönerler. 

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.LocalTime;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var currentTime = LocalTime.now();  
        var today = LocalDate.now();  
        var now1 = currentTime.atDate(today);  
        var now2 = today.atTime(currentTime);  
  
        Console.writeLine(currentTime);  
        Console.writeLine(today);  
        Console.writeLine(now1);  
        Console.writeLine(now2);  
    }  
}
```

`LocalDateTime` sınıfının `toLocalDate` ve `toLocalTime` metotları ile ilgili bilgilerden oluşan sırasıyla `LocalDate` ve `LocalTime` referansları elde edilebilir.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDateTime;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var now = LocalDateTime.now();  
        var date = now.toLocalDate();  
        var time = now.toLocalTime();  
  
        Console.writeLine(now);  
        Console.writeLine(date);  
        Console.writeLine(time);  
    }  
}
```

Belirli bir tarih aralığında geçen zamanın hesaplanabilmesi için `ChronoUnit` enum sınıfı kullanılır. Bu sınıfın `between` metodu ile iki tarih, zaman ya da tarih-zaman bilgisi istenilen birimde elde edilebilir. Aşağıdaki demo örnekte `6 Şubat 2023 saat 04:02:00` da gerçekleşen depremden günümüze kadar geçen zaman çeşitli birimlerde hesaplanmıştır

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDateTime;  
import java.time.Month;  
import java.time.temporal.ChronoUnit;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var earthquakeDateTime = LocalDateTime.of(2023, Month.FEBRUARY, 6, 4, 2);  
        var now = LocalDateTime.now();  
        var days = ChronoUnit.DAYS.between(earthquakeDateTime, now);  
        var totalYears = days / 365.;  
        var hours = ChronoUnit.HOURS.between(earthquakeDateTime, now);  
        var weeks = ChronoUnit.WEEKS.between(earthquakeDateTime, now);  
  
        Console.writeLine("Days:%s", days);  
        Console.writeLine("Total Years:%s", totalYears);  
        Console.writeLine("Hours:%s", hours);  
        Console.writeLine("weeks:%s", weeks);  
    }  
}
```


Bu sınıfların karşılaştırma işlemlerinde kullanılan `isAfter, isBefore ve compareTo` metotları vardır.

**Sınıf Çalışması:** Klavyeden gün, ay ve yıl bilgileri ile alınan doğum tarihine göre aşağıdaki mesajlardan birini yazdıran programı yazınız

1. Doğum günü henüz gelmemişse, `Doğum gününüz şimdiden kutlu olsun. Yaşınız:49.13`
2. Doğum günü geçmişse, `Geçmiş doğum gününüz kutlu olsun. Yaşınız:49.13`
3. O gün doğum günü ise, `Doğum gününüz kutlu olsun. Yaşınız:49`


**Çözüm - 1:**
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.temporal.ChronoUnit;  
  
class Application {  
    private static void printStatus(int day, int month, int year)  
    {  
        var today = LocalDate.now();  
        var birthDate = LocalDate.of(year, month, day);  
        var birthDay = birthDate.withYear(today.getYear());  
        var age = ChronoUnit.DAYS.between(birthDate, today) / 365.;  
  
        if (today.isBefore(birthDay))  
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);  
        else if (today.isAfter(birthDay))  
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);  
        else  
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);  
    }  
  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Gün?");  
        var month = Console.readInt("Ay?");  
        var year = Console.readInt("Yıl?");  
  
        printStatus(day, month, year);  
    }  
}
```

**Çözüm - 2:**
```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.temporal.ChronoUnit;  
  
class Application {  
    private static void printStatus(int day, int month, int year)  
    {  
        var today = LocalDate.now();  
        var birthDate = LocalDate.of(year, month, day);  
        var birthDay = birthDate.withYear(today.getYear());  
        var age = ChronoUnit.DAYS.between(birthDate, today) / 365.;  
        var res = today.compareTo(birthDay);  
  
        if (res < 0)  
            Console.writeLine("Doğum gününüz şimdiden kutlu olsun. Yaşınız:%.2f", age);  
        else if (res > 0)  
            Console.writeLine("Geçmiş doğum gününüz kutlu olsun. Yaşınız:%.2f", age);  
        else  
            Console.writeLine("Doğum gününüz kutlu olsun. Yaşınız:%.0f", age);  
    }  
  
    public static void run(String[] args)  
    {  
        var day = Console.readInt("Gün?");  
        var month = Console.readInt("Ay?");  
        var year = Console.readInt("Yıl?");  
  
        printStatus(day, month, year);  
    }  
}
```

`DateTimeFormatter` sınıfı ile formatlama yapılabilir. Bu sınıfın static `ofPattern` metoduna özel karakterlerden oluşan bir pattern verilerek formatlama yapılır. Bu sınıfın format metodu ile, ilgili tarih, zaman ya da tarih-zaman bilgisinden ilgili formatta yazı karşılığı elde edilebilir. Pattern'e ilişkin özel karakterler [DataTimeFormatter](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html) dokümantasyonundan elde edilebilir. 

`LocalDate, LocalTime, LocalDateTime` sınıflarının `parse` metotları ile yazıdan ilgili nesne elde edilebilir. parse metotları yazının geçersiz olması durumunda `DataTimeParseException` nesnesi fırlatırlar.

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-s-n");  
        var now = LocalDateTime.now();  
  
        Console.writeLine(now);  
        Console.writeLine(now.format(formatter));  
    }  
}
```


```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.format.DateTimeFormatter;  
import java.time.format.DateTimeParseException;  
  
class Application {  
    public static void run(String[] args)  
    {  
        try {  
            var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
            var date = LocalDate.parse(Console.readLine("Input date text"), formatter);  
  
            Console.writeLine(date);  
        }  
        catch (DateTimeParseException e) {  
            Console.Error.writeLine("Invalid format for date");  
        }  
    }  
}
```

Bir tarihe ilişkin ayın son günü çeşitli şekillerde bulunabilir. Aşağıdaki demo örnekte `***` ile belirtilen çağrı içlerinde en az maliyetli olandır. lengthOfMonth metodu ile ilgili tarihe ilişkin son günün değeri elde edilebilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.temporal.TemporalAdjusters;  
  
class Application {  
    public static void run(String [] args)  
    {  
        var today  = LocalDate.now();  
        var endOfMonth1 = today.withDayOfMonth(1).plusMonths(1).minusDays(1);  
        var endOfMonth2 = today.with(TemporalAdjusters.lastDayOfMonth());  
        var endOfMonth3 = today.withDayOfMonth(today.lengthOfMonth());  //***
  
        Console.writeLine(endOfMonth1);  
        Console.writeLine(endOfMonth2);  
        Console.writeLine(endOfMonth3);  
    }  
}
```


Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
import org.csystem.datetime.DateTime;  
  
import java.time.LocalDate;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var expiryMonth = Console.readInt("Input expiry month:");  
            var expiryYear = Console.readInt("Input expiry year:");  
            var expiryDate = LocalDate.of(expiryYear, expiryMonth, 1);  
  
            expiryDate = expiryDate.withDayOfMonth(expiryDate.lengthOfMonth());  
  
            Console.writeLine(expiryDate);  
  
            Console.writeLine(LocalDate.now().isAfter(expiryDate) ? "Card expired" : "Card is available");  
        }  
    }  
}
```

Elimizde yıl ve ay bilgisi varsa `YearMonth` sınıfı ile ayın son günü elde edilebilir.

Yukarıdaki demo örnek aşağıdaki gibi de yapılabilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
import java.time.LocalDate;  
import java.time.YearMonth;  
  
class Application {  
    public static void run(String[] args)  
    {  
        while (true) {  
            var expiryMonth = Console.readInt("Input expiry month:");  
            var expiryYear = Console.readInt("Input expiry year:");  
            var expiryDate = YearMonth.of(expiryYear, expiryMonth).atEndOfMonth();  
  
            Console.writeLine(expiryDate);  
            Console.writeLine(LocalDate.now().isAfter(expiryDate) ? "Card expired" : "Card is available");  
        }  
    }  
}
```

##### API, Library ve Framework Kavramları

Bu kavramlar için net birer tanım yoktur ancak burada pek çok programcı açısından kabul edilen betimlemeleri üzerinde durulacaktır. Bu kavramlar bazı geliştirmeler açısından birbirine çok yakın olabilmektedir. Hatta bazı durumlarda bir geliştirmenin hangisi olduğu konusunda görüş ayrılıkları da olabilir.

**API (Application Programming Interface):** Bir yazılım sisteminde uygulama programcısının doğrudan erişebileceği veya çağırabileceği, o sistem ile uygulama programcısı arasında köprü oluşturan metot, sınıfı ya da çeşitli formatlardaki bilgilere denir. API oldukça elastik bir terimdir. Hangi metotlara API denebileceği tartışmaya açıktır ancak genel olarak söylemek gerekirse, uygulama programcısını ilgili sistem ile işlemler yaparken detaylardan soyutlayan sınıf, metot ya da çeşitli formatlardaki bilgiler anlaşılır. Örneğin, `Java API`dendiğinde Java sınıfları ve metotlar anlaşılır. Yine örneğin `Java 8 Date Time API` dendiğinde Java 8 ile eklenen tarih-zaman türleri ve metotları anlaşılır.. Yine örneğin Merkez Bankası'ından o anki döviz kuru bilgilerini elde edebilmek için erişilen ve yanıt olarak elde edilen bilgilerin tamamına API denilebilir. Yine örneğin, `Windows API` dendiğinde Windows işletim sisteminde temel işlemler yapmak için kullanılan aşağı seviyeli fonksiyonlar anlaşılır.

**Kütüphane (library) ve Framework:** Bu kavramların sınırları tam belli değildir. Değişik kaynaklarda değişik biçimlerde sınırlar çizilebilmektedir ancak bir sisteme framework diyebilmek için aşağıdaki iki özelliğin bulunması yönünde bir eğilim vardır:

1. Karmaşıklığın kullanıcıya daha basit gösterilmesi ve detayların yani yük oluşturan kısımların kullanıcının üzerinden alınmasıdır
2. Kod akışının ele geçirilmesi (yani yönetilmesi) ve duruma göre programcıya belli zamanlarda verilmesi. Buna genel olarak **Inversion of Control (IOC)** de denilmektedir.

Kütüphanelerde arka planda bir takım işlemler kullanıcılar için yapılır. Akışın ele geçirilmesi gibi bir amaç yoktur. Kütüphanelerde program akışı kullanıcıdadır. Programcı isterse kütüphaneye ilişkin sınıfları ve metotları kullanabilir. Şüphesiz kütüphane içerisindeki bu sınıflar ve metotlar yararlı bir takım işlemler yaparlar. Şüphesiz pek çok framework aynı zamanda birden fazla kütüphaneye ve API'lere sahiptir. Bazı durumlarda o sistemin bir framework mü ya da bir kütüphane mi olduğu konusunda tereddütler olabilir. 

##### Nested Types

Java'da iç içe tür bildirimleri (nested types/nested type declarations) yapılabilir. Örneğin, sınıf içerisinde sınıf bildirimi, sınıf içersinde enum class bildirimi, sınıf içerisinde interface bildirimi vb. Bu bölümde iç içe sınıf bildirimleri ele alınacaktır. Diğer bildirimler iç içe sınıf bildirimlerine göre daha az detaylıdır. İç içe sınıf bildirimleri şunlardır: **local classes, nested classes, inner classes, anonymous classes, lambda expressions (since Java 8).** 

Herhangi bir user type type (UDT) içerisinde bildirilmemiş UDT'lere **top level types** denir. Bu anlamda hiç bir UDT içerinde bildirilmemiş sınıflara **top level classes** denir. 

**Soru:** Aşağıdaki demo sınıfı, int türden yeni bir yetenek (ability) eklendiğinde `abilityTotal` ve `abilityAverage` metotları değiştirilmek zorunda kalmayacak şekilde güncelleyiniz

```java  
class Fighter {  
    private String m_name;  
    private int m_health;  
    private int m_strength;  
    private int m_agility;  
  
    public Fighter(String name)  
    {  
        m_name = name;  
    }  
  
    public String getName()  
    {  
        return m_name;  
    }  
  
    public void setName(String name)  
    {  
        m_name = name;  
    }  
  
    public int getHealth()  
    {  
        return m_health;  
    }  
  
    public void setHealth(int health)  
    {  
        m_health = health;  
    }  
  
    public int getStrength()  
    {  
        return m_strength;  
    }  
  
    public void setStrength(int strength)  
    {  
        m_strength = strength;  
    }  
  
    public int getAgility()  
    {  
        return m_agility;  
    }  
  
    public void setAgility(int agility)  
    {  
        m_agility = agility;  
    }  
  
    public int abilityTotal()  
    {  
        return m_health + m_strength + m_agility;  
    }  
  
    public double abilityAverage()  
    {  
        return abilityTotal() / 3.;  
    }  
  
    //...  
}
```

**Çözüm 1**

```java
class Fighter {  
    private static final int COUNT = 4;  
    private String m_name;  
    private final int [] m_abilities;  
  
    public Fighter(String name)  
    {  
        m_name = name;  
        m_abilities = new int[COUNT];  
    }  
  
    public String getName()  
    {  
        return m_name;  
    }  
  
    public void setName(String name)  
    {  
        m_name = name;  
    }  
  
    public int getHealth()  
    {  
        return m_abilities[0];  
    }  
  
    public void setHealth(int health)  
    {  
        m_abilities[0] = health;  
    }  
  
    public int getStrength()  
    {  
        return m_abilities[1];  
  
    }  
  
    public void setStrength(int strength)  
    {  
        m_abilities[1] = strength;  
    }  
  
    public int getAgility()  
    {  
        return m_abilities[2];  
    }  
  
    public void setAgility(int agility)  
    {  
        m_abilities[2] = agility;  
    }  
    public int getSpeed()  
    {  
        return m_abilities[3];  
    }  
  
    public void setSpeed(int speed)  
    {  
        m_abilities[3] = speed;  
    }  
  
    public int abilityTotal()  
    {  
        return (int)ArrayUtil.sum(m_abilities);  
    }  
  
    public double abilityAverage()  
    {  
        return abilityTotal() / (double)m_abilities.length;  
    }  
  
    //...  
}
```

**Çözüm 2:**

```java
class Fighter {  
    private String m_name;  
    private final int [] m_abilities;  
    private enum ABILITY {HEALTH, STRENGTH, AGILITY, SPEED, COUNT}  
  
    public Fighter(String name)  
    {  
        m_name = name;  
        m_abilities = new int[ABILITY.COUNT.ordinal()];  
    }  
  
    public String getName()  
    {  
        return m_name;  
    }  
  
    public void setName(String name)  
    {  
        m_name = name;  
    }  
  
    public int getHealth()  
    {  
        return m_abilities[ABILITY.HEALTH.ordinal()];  
    }  
  
    public void setHealth(int health)  
    {  
        m_abilities[ABILITY.HEALTH.ordinal()] = health;  
    }  
  
    public int getStrength()  
    {  
        return m_abilities[ABILITY.STRENGTH.ordinal()];  
  
    }  
  
    public void setStrength(int strength)  
    {  
        m_abilities[ABILITY.STRENGTH.ordinal()] = strength;  
    }  
  
    public int getAgility()  
    {  
        return m_abilities[ABILITY.AGILITY.ordinal()];  
    }  
  
    public void setAgility(int agility)  
    {  
        m_abilities[ABILITY.AGILITY.ordinal()] = agility;  
    }  
  
    public int getSpeed()  
    {  
        return m_abilities[ABILITY.SPEED.ordinal()];  
    }  
  
    public void setSpeed(int speed)  
    {  
        m_abilities[ABILITY.SPEED.ordinal()] = speed;  
    }  
  
    public int abilityTotal()  
    {  
        return (int)ArrayUtil.sum(m_abilities);  
    }  
  
    public double abilityAverage()  
    {  
        return abilityTotal() / (double)m_abilities.length;  
    }  
  
    //...  
}
```

###### Local Classes

Bir blok içerisinde bildirilen sınıflara **local classes** denir. Local classes pratikte çok kullanılmaz. Birim testi araçları yaygınlaşmadan önce test işlemlerinde kullanılırdı. **Burada yerel sınıfları özellikle ileride ele alacağımız diğer nested type'larda da önemli olacak olan bir takım kavramları daha kolay öğrenmek için öğreneceğiz.** Yerel sınıfların ara kod isimlendirmesinin Java derleyicisi açısından genel biçimi şu şekildedir:

```
<top level tür ismi>$<n><yerel sınıf ismi>
```

Burada top level tür ismi yerel sınıfın bildirildiği bloğun ait olduğu sınıftır. n değeri ise soldan sağa ve yukarıdan aşağıya olmak üzere bildirilen yerel sınıf numarasıdır. 

Aşağıdaki demo örnekte sınıflara ilişkin byte code'ların dosya isimleri aşağıdaki gibidir:

```
Applicatiom.class
Sample.class
Application$1Sample.class
Application$2Sample.class
Application$1Mample.class
```

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        class Sample {  
            //...  
            public void foo()  
            {  
                Console.writeLine("Application$1Sample.foo");  
            }  
        }  
  
        var s = new Sample();  
  
        s.foo();  
    }  
  
    public static void doWork()  
    {  
        class Sample {  
            //...  
            public void foo()  
            {  
                //...  
            }  
        }  
  
        class Mample {  
            //...  
        }  
    }  
}  
  
class Sample {  
    //...  
  
    public void foo()  
    {  
        //...  
    }  
}
```

Yerel sınıfların static metotları da olabilir


```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        class Sample {  
            //...  
            public static void foo()  
            {  
                Console.writeLine("Application$1Sample.foo");  
            }  
        }  
  
        Sample.foo();  
    }  
}
```

Yerel bir sınıf içerisinde kendisinden önce bildirilmiş bir yerel değişken ya da bir parametre değişkeni kullanılabilir. Bu kavrama **capture** denir. Bu değişken static metotlar içerisinde kullanılamaz.

Aşağıdaki demo örnekte neden yerel sınıf kullanıldığına değil capture kavramına odaklanınız.

Örnekteki `DateUtil` yerel sınıfının üretilen byte code'u yaklaşık olarak aşağıdaki gibidir
```java
class Application$1DateUtil {
	private final int m_year;
	
	public Application$1DateUtil(int year)
	{
		m_year = year;
	}
	
	public boolean isLeapYear()  
	{  
		return m_year % 4 == 0 && m_year % 100 != 0 || m_year % 400 == 0;  
	}  
}
```

Örnekteki `DateUtil` yerel sınıfı türünden nesne yaratıldığında derleyici yaklaşık olarak aşağıdaki gibi bir kod üretir
```java
var util = new Application$1DateUtil(year);
```

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var year = Console.readInt("Input year:");  
  
        class DateUtil {  
            public boolean isLeapYear()  
            {  
                return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;  
            }  
        }  
  
        var util = new DateUtil();  
        
        Console.writeLine(util.isLeapYear() ? "Leap year" : "Not a leap year");  
    }  
}
```

Yakalanan bir yerel değişken veya bir parametre değişkeninin değeri faaliyet alanı (scope) boyunca değiştirilemez. Bu tip değişkenlere **effectively final** değişkenler denir. Bu kavramın yakalamadaki karşılığı Java 8 ile dile eklenmiştir. Java 8'den önce yakalanan bir değişkenin final olarak bildirilmesi zorunluydu. 

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        var year = Console.readInt("Input year:");  
  
        class DateUtil {  
            public boolean isLeapYear()  
            {  
                return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;  
            }  
        }  
  
        var util = new DateUtil();  
        Console.writeLine(util.isLeapYear() ? "Leap year" : "Not a leap year");  
    }  
}
```

**Anahtar Notlar:** Capture kavramı ve yakalanan bir değişkenin effectively final olması yalnızca yerel sınıflara özgü değildir. Anonim sınıflar ve lambda ifadelerinde de kullanılan kavramlardır. Bu anlamda yakalama özellikleri (effectively final olması) anonim sınıflar ve lambda ifadelerinde de aynıdır.

###### Nested Classes

Bir sınıf içerisinde başka bir sınıfın static olarak bildirilmesine **nested class** denir. Bu bildirim ile aslında sınıfa static bir eleman (member) eklenmiş olur. Nested sınıfların ara kod isimlendirmesinin Java derleyicisi açısından genel biçimi şu şekildedir:

```
<top level tür ismi>$<nested sınıf ismi>
```

Aşağıdaki demo sınıflara ilişkin üretilen byte code dosya isimleri şu şekildedir:

```
A.class
A$B.class
A$B$X.class
A$C.class
A$D.class
A$E.class
```


```java
class A {  
    private static class B {  
        //...  
        class X {  
            //...  
        }  
    }  
  
    public static class C {  
        //...  
    }  
  
    protected static class D {  
        //...  
    }  
  
    static class E {  
        //...  
    }  
}
```


Nested bir sınıf static bir eleman olduğuna göre, sınıf dışından sınıf ismi nokta operatörü ile erişilebilir

Aşağıdak, demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        A.B.bar();  
        var b = new A.B();  
  
        b.foo();  
    }  
}  
  
class A {  
    public static class B {  
        //...  
  
        public void foo()  
        {  
            Console.writeLine("A.B.foo");  
        }  
  
        public static void bar()  
        {  
            Console.writeLine("A.B.bar");  
        }  
    }  
```

Nested bir sınıf içerisinde niteliksiz olarak kullanılan bir isim, niteliksiz isim arama (unqualified name lookup) genel kurallarına göre aranıyorsa ve sınıf içeriside doğrudan ya da dolaylı taban sınıfları da dahil bulunamıyorsa ait olduğu sınıf içerisinde de aranır. Bulunursa yine geçerlilik kontrolü yapılır. 

Aşağıdaki demo örneği inceleyiniz

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        A.B.bar();  
    }  
}  
  
class A {  
    public static void foo()  
    {  
        Console.writeLine("A.foo");  
    }  
  
    public static class B {  
        //...  
        public static void bar()  
        {  
            Console.writeLine("A.B.bar");  
            foo();  
        }  
    }  
}
```

Aşağıdaki demo örnekte `***` ile belirtilen bar çağrısı ile metot kendi kendisini çağırmıştır (recursion).

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        A.B.bar();  
    }  
}  
  
class A {  
    public static void bar()  
    {  
        Console.writeLine("A.bar");  
    }  
  
    public static class B {  
        //...  
        public static void bar()  
        {  
            Console.writeLine("A.B.bar");  
            bar(); //***  
        }  
    }  
}
```

Aşağıdaki demo örnekte A sınıfının bar metodu nitelikli olarak çağrılabilir

```java
package org.csystem.app;  
  
import com.karandev.io.util.console.Console;  
  
class Application {  
    public static void run(String[] args)  
    {  
        A.B.bar();  
    }  
}  
  
class A {  
    public static void bar()  
    {  
        Console.writeLine("A.bar");  
    }  
  
    public static class B {  
        //...  
        public static void bar()  
        {  
            Console.writeLine("A.B.bar");  
            A.bar(); //***  
        }  
    }  
}
```








