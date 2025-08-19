### C ve Sistem Programcıları Derneği
### Java ile Uygulama Geliştirme 1
### Eğitmen: Oğuz KARAN

##### Maven ile Kütüphane Kullanımı

Genel olarak bir kütüphane `maven` build aracı ile aşağıdakilerden biri ya da birkaçından kullanılabilir:
1. Uygulama geliştirilirken kullanılan host makinenin içerisindeki `maven local repository` ile kullanılabilir. Bu repository maven programı geçerli veya geçersiz ilk kez çalıştırıldığında genel olarak `.m2` isimli bir directory biçiminde yaratılır. Bu directory'nin aslında default ismi ve default yeri değiştirilebilir. Ancak pratikte özel durumlar dışında ismi ve yeri değiştirilmez. mvn programı install seçeneği ile doğrudan çalıştırıldığında konfigürasyona göre ilgili kütüphane maven local repository'ye yüklenir. Aşağıda linki verilen demo uygulamayı inceleyiniz:
> [001-DemoMavenLocalAndSystemScope](https://github.com/oguzkaran/JavaApp1-Aug-2025/tree/main/src/Projects/001-DemoMavenLocalAndSystemScope)
> 
>2. Projenin içerisinden ancak başka bir path'den kullanılabilir. Genelde bu kullanımda kütüphane, proje içerisinde bir directory'ye konuşlandırılır ve dependency olarak `<systemPath>` içerisinde belirtilerek projeye dahil edilir. Bu kullanımda kütüphanenin update edilmesi gibi durumlarını yönetmek zor olabilmektedir. Bu sebeple, bu kullanımda maven uzun zamandır uyarı vermektedir. Bu uyarı bu kullanımın deprecated olduğu ve ileride devre dışı kalacağına yöneliktir. Aşağıda linki verilen demo uygulamayı inceleyiniz:
> [001-DemoMavenLocalAndSystemScope](https://github.com/oguzkaran/JavaApp1-Aug-2025/tree/main/src/Projects/001-DemoMavenLocalAndSystemScope)
> 
>3. Özel olarak configure edilmiş ve kütüphanelerin uygun şekilde maven tarafından install edilebildiği remote repository'lerden kullanılabilir. Bu tarz bir repository oluşturmanın Java ve maven dışında da ayrıntıları vardır. Burada bu tarz bir server'ı oluştrma ele alınmayacaktır. Github maven remote repository oluşturmayı destekler. Burada github üzerinde remote repository oluşturmayı ele alacağız ve kurs boyunca genel kütüphanelerimizi remote repository'lere içerisine atıp oradan kullanacağız. Github üzerinde remote bir repository oluşturmanın ve remote repository'ye install etmenin genel adımları şunlardır:

```
git clone https://github.com/oguzkaran/javaapp1-aug-2025-maven-repo
```

```
git clone https://github.com/oguzkaran/javaapp1-aug-2025-maven-repo
```

```
git config --global user.email "your email"
```


	- Kolonlanan repository'ye ilgili kütüphane dosyasının maven ile install edilmesi için aşağıdaki örnek komut kullanılabilir:

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

>4. Apache firmasının sunduğu Maven Central denilen bir server'dan kullanılabilir. Bu durumda ilgili kütüphanenin bu server içerisinde install edilmesi gerekir. Maven central kullanımı ileride ele alınacaktır.
>
>Maven bir kütüphanenin dependency'sini gördüğünde eğer 2. kullanım durumu yoksa aramayı belli bir sırada yapar. Bu sıra şu şekildedir:
>- maven local repository
>- maven central
>- maven remote repositories
>
>Eğer maven central'da veya maven remote repository'de bulursa yine maven local repository'ye indirir. Yani sonuçta maven 2. kullanım hariç kütüphaneyi maven local repository'den kullanır.





