
/*

**Açıklamalar:**

- Sınıfın `LocalTime` parametreli ctor'u ile yaratılan nesne için,
 aldığı zaman geldiğinde `start` metodu ile verilen **callback**'e ilişkin metot çağrılacaktır.

- Sınıfın `LocalDateTime` parametreli ctor'u ile yaratılan nesne için,
aldığı tarih-zaman geldiğinde `start` metodu ile verilen **callback**'e ilişkin metot çağrılacaktır

- Sınıfın `LocalDate` parametreli ctor'u ile yaratılan nesne için,
aldığı tarih geldiğinde (geceyarısı) geldiğinde `start` metodu ile verilen **callback**'e ilişkin metot çağrılacaktır.

- Sınıf tarihin, zamanın ya da tarih zamanın geçmiş olup olmadığını kontrol etmeyecektir.

- Sınıfı `Timer` kullanarak yazınız

- Bir `Alarm` nesnesinden **yalnızca bir kez** start yapılabilecektir.
- Sınıfın cancel metodu Alarm'ı iptal eder.

 */




package org.csystem.scheduler.timeout;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimerTask;

public class Alarm {
    public Alarm(LocalTime time)
    {  
        throw new UnsupportedOperationException("Not implemented yet.");  
    }  
  
    public Alarm(LocalDateTime dateTime)
    {  
        throw new UnsupportedOperationException("Not implemented yet.");  
    }  
  
    public Alarm(LocalDate date)
    {  
        throw new UnsupportedOperationException("Not implemented yet.");  
    }  
  
    public void start(TimerTask timerTask)
    {  
        throw new UnsupportedOperationException("Not implemented yet.");  
    }  
  
    public void cancel()  
    {  
        throw new UnsupportedOperationException("Not implemented yet.");  
    }  
}