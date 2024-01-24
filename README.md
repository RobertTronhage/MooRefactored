Instructions in swedish:

Refaktorisering för clean och testbar kod 

Syftet med labben är att öva på att refaktorisera kod så att den får bättre struktur och framför allt att enhetstester över huvud taget går att genomföra. 

Övningen utgår från en helt fungerande implementering av spelet Bulls&Cows, men som medvetet är ostrukturerat och svårt att testa på annat sätt än att spela och manuellt testa helheten. 

Det finns självklart många sätt att refaktorisera kod och många åsikter om vad som är ”renast”, men några principer kan ”alla” enas om. Dessa är krav vid labbens redovisning: 
Koden skall delas upp så att spellogik/spelstyrning, användar-i/o och databasoperationer läggs i separata skikt.  
Spellogik, databas- och i/o-skikten skall beskrivas med java-interface för tydlighet och ge möjlighet för alternativa implementeringar och möjlighet att mocka vid enhetstestning.
Dependency injection skall användas, enklast som manuellt kodad DP utförd av main vid programstart. Ingen annan applikationskod i main-klassen! 
För att visa uppnådd testbarhet skall några representativa testfall implementeras. De behöver inte vara heltäckande, men skall visa att koden är testbar. Använd mockning vid behov. 
Gör några generella refaktoriseringar där du tycker att koden ser ful ut.
