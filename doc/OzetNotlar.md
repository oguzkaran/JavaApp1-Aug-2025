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

var değişkenler mümkün olduğunca kullanılmalıdır. Bu anlamda bazı programcılar temel türler (primitive types) dışında mümkün olduğunca kullanmayı tercih ederler. Biz, tür ne olursa olsun kullanılabildiği her yerde kullanmayı tercih edeceğiz (always applicable).

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

