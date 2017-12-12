#!/bin/sh

file=$1

# Primitive "translation" from Slovak to English

perl -i -p -e 's/ a / and /' $file

perl -i -p -e 's/^tu /here /' $file
perl -i -p -e 's/ vo? / in /' $file


perl -i -p -e 's/((?<= )|(?<=^))ja /I /' $file
perl -i -p -e "s/((?<= )|(?<=^))ty /you /" $file
perl -i -p -e "s/^my /we /" $file
perl -i -p -e "s/^vy /y'all /" $file
perl -i -p -e "s/^on /he /" $file
perl -i -p -e "s/^ona /she /" $file
perl -i -p -e "s/^oni /they /" $file
perl -i -p -e "s/^ony /they /" $file

perl -i -p -e 's/ som(?= |$)/ am/' $file
perl -i -p -e 's/ (si|sú|sme|ste)(?= |$)/ are/' $file
perl -i -p -e 's/ je(?= |$)/ is/' $file

perl -i -p -e 's/ nie (am|is|are)(?=$| )/ $1 not/' $file


perl -i -p -e 's/ idete / are going /' $file

perl -i -p -e 's/ cez / via /' $file
perl -i -p -e 's/ po / /' $file
perl -i -p -e 's/ zo? / from /' $file

perl -i -p -e 's/ muž(|a)($| )/ man$2/' $file
perl -i -p -e 's/ muž(i|ov)($| )/ men$2/' $file
perl -i -p -e 's/ pán(|a)($| )/ gentleman$2/' $file
perl -i -p -e 's/ pán(i|ov)($| )/ gentlemen$2/' $file

# Verbs

perl -i -p -e 's/ býva(?=$| )/ resides/' $file
perl -i -p -e 's/ býva[^ \n]+(?=$| )/ reside/' $file
perl -i -p -e 's/ nebýva(?=$| )/ does not reside/' $file
perl -i -p -e 's/ nebýva[^ \n]+(?=$| )/ do not reside/' $file
perl -i -p -e 's/ číta[^ ]*(?=$| )/ reads/' $file
perl -i -p -e 's/ nechodieva[^ \n]+(?=$| )/ do not go/' $file
perl -i -p -e 's/ nechodieva/ does not go/' $file
perl -i -p -e 's/ hovor[^ ]*(?=$| )/ speaks/' $file
perl -i -p -e 's/ chod(ia|(í(t|m)e))(?=$| )/ walk/' $file
perl -i -p -e 's/ chodí(?=$| )/ walks/' $file
perl -i -p -e 's/ chodieva[^ \n]+(?=$| )/ walk/' $file
perl -i -p -e 's/ chodieva(?=$| )/ walks/' $file
perl -i -p -e 's/ kon(a|á)[^ \n]+(?=$| )/ act/' $file
perl -i -p -e 's/ koná(?=$| )/ acts/' $file
perl -i -p -e 's/ kričí(?=$| )/ shouts/' $file
perl -i -p -e 's/ krič(í(m|t)e|ia)(?=$| )/ shout/' $file
perl -i -p -e 's/ nekon(a|á)[^ \n]+(?=$| )/ do not act/' $file
perl -i -p -e 's/ nekoná(?=$| )/ does not act/' $file
# commented out line matches mother incorrectly
#perl -i -p -e 's/ m(a|á)[^ \n]{1,4}(?=$| )/ have/' $file
perl -i -p -e 's/ má(?=$| )/ has/' $file
perl -i -p -e 's/ nem(a|á)[^ \n]+(?=$| )/ do not have/' $file
perl -i -p -e 's/ nemá(?=$| )/ does not have/' $file
perl -i -p -e 's/ pamätá(?=$| )/ remembers/' $file
perl -i -p -e 's/ pamät[^ \n]+(?=$| )/ remember/' $file
perl -i -p -e 's/ nepamätá(?=$| )/ does not remember/' $file
perl -i -p -e 's/ nepamät[^ \n]+(?=$| )/ do not remember/' $file
perl -i -p -e 's/ počúva(?=$| )/ listens/' $file
perl -i -p -e 's/ počúva((m|t)e|jú)(?=$| )/ listen/' $file
perl -i -p -e 's/ pozn(a|á)[^ \n]+(?=$| )/ know/' $file
perl -i -p -e 's/ pozná(?=$| )/ knows/' $file
perl -i -p -e 's/ nepozn(a|á)[^ \n]+(?=$| )/ know not/' $file
perl -i -p -e 's/ nepozná(?=$| )/ knows not/' $file
perl -i -p -e 's/ prichádza[^ \n]+(?=$| )/ arrive/' $file
perl -i -p -e 's/ prichádza(?=$| )/ arrives/' $file
perl -i -p -e 's/ neprichádza[^ \n]+(?=$| )/ do not arrive/' $file
perl -i -p -e 's/ neprichádza(?=$| )/ does not arrive/' $file
perl -i -p -e 's/ robí(?=$| )/ makes/' $file
perl -i -p -e 's/ (robia|robí(m|t)e)(?=$| )/ make/' $file
perl -i -p -e 's/ rozpráva[^ \n]+(?=$| )/ speak/' $file
perl -i -p -e 's/ rozpráva(?=$| )/ speaks/' $file
perl -i -p -e 's/ nerozpráva[^ \n]+(?=$| )/ do not speak/' $file
perl -i -p -e 's/ nerozpráva(?=$| )/ does not speak/' $file
perl -i -p -e 's/ spávajú(?=$| )/ are sleeping/' $file
perl -i -p -e 's/ spáva(?=$| )/ sleeps/' $file
perl -i -p -e 's/ spáva((t|m)e|jú)(?=$| )/ sleep/' $file
perl -i -p -e 's/ sedí(m|t)e/ are sitting/' $file
perl -i -p -e 's/ sedia/ are sitting/' $file
perl -i -p -e 's/ sedí/ sits/' $file
perl -i -p -e 's/ spá(?=$| )/ sleeps/' $file
perl -i -p -e 's/ spieva(?=$| )/ sings/' $file
perl -i -p -e 's/ spieva((t|m)e|jú)(?=$| )/ sing/' $file
perl -i -p -e 's/ stráca(?=$| )/ loses/' $file
perl -i -p -e 's/ stráca(t|m)e(?=$| )/ lose/' $file
perl -i -p -e 's/ strácajú/ lose/' $file
perl -i -p -e 's/ nesp(a|á)[^ \n]+(?=$| )/ do not sleep/' $file
perl -i -p -e 's/ nespá(?=$| )/ does not sleep/' $file
perl -i -p -e 's/ vidí(m|te)(?=$| )/ see/' $file
perl -i -p -e 's/ vid(ia|í(t|m)e)(?=$| )/ see/' $file
perl -i -p -e 's/ vidí(?=$| )/ sees/' $file
perl -i -p -e 's/ vie(?=$| )/ is familiar with/' $file
perl -i -p -e 's/ (vie(t|m)e|vedia)(?=$| )/ are familiar with/' $file
perl -i -p -e 's/ vstáva[^ \n]+(?=$| )/ get up/' $file
perl -i -p -e 's/ vstáva(?=$| )/ gets up/' $file
perl -i -p -e 's/ nevstáva[^ \n]+(?=$| )/ do not get up/' $file
perl -i -p -e 's/ nevstáva(?=$| )/ does not get up/' $file
perl -i -p -e 's/ vychádza[^ \n]+(?=$| )/ go out/' $file
perl -i -p -e 's/ vychádza(?=$| )/ goes out/' $file
perl -i -p -e 's/ nevychádza[^ \n]+(?=$| )/ do not go out/' $file
perl -i -p -e 's/ nevychádza(?=$| )/ does not go out/' $file
perl -i -p -e 's/ začin(a|á)[^ \n]+(?=$| )/ begin/' $file
perl -i -p -e 's/ začiná(?=$| )/ begins/' $file
perl -i -p -e 's/ nezačin(a|á)[^ \n]+(?=$| )/ do not begin/' $file
perl -i -p -e 's/ nezačiná(?=$| )/ does not begin/' $file
perl -i -p -e 's/(^| )žena(?=$| )/$1the woman/' $file
perl -i -p -e 's/(^| )ženy(?=$| )/$1the women/' $file
perl -i -p -e 's/ žiada[^ \n]+(?=$| )/ ask/' $file
perl -i -p -e 's/ žiada(?=$| )/ asks/' $file
perl -i -p -e 's/ nežiada[^ \n]+(?=$| )/ do not ask/' $file
perl -i -p -e 's/ nežiada(?=$| )/ does not ask/' $file
perl -i -p -e 's/ znamen(a|á)[^ \n]+(?=$| )/ mean/' $file
perl -i -p -e 's/ znamená(?=$| )/ means/' $file
perl -i -p -e 's/ neznamen(a|á)[^ \n]+(?=$| )/ do not mean/' $file
perl -i -p -e 's/ neznamená(?=$| )/ does not mean/' $file



# Nouns

perl -i -p -e 's/ auto($| )/ car$1/' $file
perl -i -p -e 's/ autá($| )/ cars$1/' $file
perl -i -p -e 's/ brehy($| )/ riverbanks$1/' $file
perl -i -p -e 's/ breh($| )/ riverbank$1/' $file
perl -i -p -e 's/ cen(a|u)($| )/ price$2/' $file
perl -i -p -e 's/ ceny($| )/ prices$1/' $file
perl -i -p -e 's/chlap /the fellow /' $file
perl -i -p -e 's/chlapi /the fellows /' $file
perl -i -p -e 's/ dedin(a|u)($| )/ village$2/' $file
perl -i -p -e 's/ dediny($| )/ villages$1/' $file
perl -i -p -e 's/ dom($| )/ home$1/' $file
perl -i -p -e 's/ domy($| )/ homes$1/' $file
perl -i -p -e 's/(^| )družstvo(?=$| )/$1the team/' $file
perl -i -p -e 's/(^| )družstvá(?=$| )/$1the teams/' $file
perl -i -p -e 's/ hlav(a|u)($| )/ head$2/' $file
perl -i -p -e 's/ hlavy($| )/ heads$1/' $file
perl -i -p -e 's/jar(?=$| )/springtime/' $file
perl -i -p -e 's/jari(?=$| )/the springtimes/' $file
perl -i -p -e 's/jeseň(?=$| )/autumn/' $file
perl -i -p -e 's/jesene(?=$| )/the autumns/' $file
perl -i -p -e 's/ knih(a|u)($| )/ book$2/' $file
perl -i -p -e 's/ knihy($| )/ books$1/' $file
perl -i -p -e 's/ kvet($| )/ flower$1/' $file
perl -i -p -e 's/ kvety($| )/ flowers$1/' $file
perl -i -p -e 's/ les($| )/ forest$1/' $file
perl -i -p -e 's/ lesy($| )/ forests$1/' $file
perl -i -p -e 's/leto /the summer /' $file
perl -i -p -e 's/letá /summers /' $file
perl -i -p -e 's/ lúk(a|u)($| )/ meadow$2/' $file
perl -i -p -e 's/ lúky($| )/ meadows$1/' $file
perl -i -p -e 's/matka(?=$| )/mother/' $file
perl -i -p -e 's/matky(?=$| )/the mothers/' $file
perl -i -p -e 's/mesto(?=$| )/the town/' $file
perl -i -p -e 's/ mesto($| )/ town$1/' $file
perl -i -p -e 's/ mestá($| )/ towns$1/' $file
perl -i -p -e 's/mestá(?=$| )/the towns/' $file
perl -i -p -e 's/ minút(a|u)($| )/ minute$2/' $file
perl -i -p -e 's/ minúty($| )/ minutes$1/' $file
perl -i -p -e 's/ noh(a|u)($| )/ foot$2/' $file
perl -i -p -e 's/ nohy($| )/ feet$1/' $file
perl -i -p -e 's/ obraz($| )/ picture$1/' $file
perl -i -p -e 's/ obrazy($| )/ pictures$1/' $file
perl -i -p -e 's/ obchod($| )/ shop$1/' $file
perl -i -p -e 's/ obchody($| )/ shops$1/' $file
perl -i -p -e 's/ otázk(a|u)($| )/ question$2/' $file
perl -i -p -e 's/ otázky($| )/ questions$1/' $file
perl -i -p -e 's/otec(?=$| )/father/' $file
perl -i -p -e 's/oteci(?=$| )/the fathers/' $file
perl -i -p -e 's/ plot($| )/ fence$1/' $file
perl -i -p -e 's/ ploty($| )/ fences$1/' $file
perl -i -p -e 's/práca(?=$| )/work/' $file
perl -i -p -e 's/práce(?=$| )/jobs/' $file
perl -i -p -e 's/priateľ(?=$| )/a friend/' $file
perl -i -p -e 's/priateľi(?=$| )/friends/' $file
perl -i -p -e 's/ riek(a|u)($| )/ river$2/' $file
perl -i -p -e 's/ rieky($| )/ rivers$1/' $file
perl -i -p -e 's/ sten(a|u)($| )/ wall$2/' $file
perl -i -p -e 's/ steny($| )/ walls$1/' $file
perl -i -p -e 's/ strom($| )/ tree$1/' $file
perl -i -p -e 's/ stromy($| )/ trees$1/' $file
perl -i -p -e 's/ prst($| )/ finger$1/' $file
perl -i -p -e 's/ prsty($| )/ fingers$1/' $file
perl -i -p -e 's/ dvor($| )/ yard$1/' $file
perl -i -p -e 's/ dvory($| )/ yards$1/' $file
perl -i -p -e 's/(^| )rodina(?=$| )/$1the family/' $file
perl -i -p -e 's/rodiny(?=$| )/families/' $file
perl -i -p -e 's/škola(?=$| )/the school/' $file
perl -i -p -e 's/ škol(a|u)($| )/ school$2/' $file
perl -i -p -e 's/( |^)školy(?=$| )/$1the schools/' $file
perl -i -p -e 's/ stavb(a|u)($| )/ building$2/' $file
perl -i -p -e 's/ stavby($| )/ buildings$1/' $file
perl -i -p -e 's/ ruk(a|u)($| )/ hand$2/' $file
perl -i -p -e 's/ ruky($| )/ hands$1/' $file
perl -i -p -e 's/ stanic(a|u)($| )/ station$2/' $file
perl -i -p -e 's/ stanice($| )/ stations$1/' $file
perl -i -p -e 's/ tried(a|u)($| )/ class$2/' $file
perl -i -p -e 's/ triedy($| )/ classes$1/' $file
perl -i -p -e 's/(^| )ulic(a|u)(?=$| )/$1the street/' $file
perl -i -p -e 's/ ulice($| )/ streets$1/' $file
perl -i -p -e 's/ulice(?=$| )/the streets/' $file
perl -i -p -e 's/ vec($| )/ thing$1/' $file
perl -i -p -e 's/ veci($| )/ things$1/' $file
perl -i -p -e 's/ večer($| )/ evening$1/' $file
perl -i -p -e 's/ večery($| )/ evenings$1/' $file
perl -i -p -e 's/ voz($| )/ vehicle$1/' $file
perl -i -p -e 's/ vozy($| )/ vehicles$1/' $file
perl -i -p -e 's/ záhrad(a|u)($| )/ garden$2/' $file
perl -i -p -e 's/ záhrady($| )/ gardens$1/' $file
perl -i -p -e 's/zima(?=$| )/winter/' $file
perl -i -p -e 's/zimy(?=$| )/winters/' $file

# Adjectives

perl -i -p -e 's/ hlavn[^$ ]+($| )/ main$1/' $file
perl -i -p -e 's/ ktor[^$ ]+($| )/ which$1/' $file
perl -i -p -e 's/ vysok[^$ ]+($| )/ tall$1/' $file
perl -i -p -e 's/ nov[^$ ]+($| )/ new$1/' $file
perl -i -p -e 's/ prav[^$ ]+($| )/ right$1/' $file
perl -i -p -e 's/ širok[^$ ]+($| )/ wide$1/' $file
perl -i -p -e 's/ nejak[^$ ]+($| )/ some$1/' $file
perl -i -p -e 's/ tak[^$ ]+($| )/ such$1/' $file
perl -i -p -e 's/ nízk[^$ ]+($| )/ low$1/' $file
perl -i -p -e 's/ jednoduch[^$ ]+($| )/ simple$1/' $file
perl -i -p -e 's/ dobr[^$ ]+($| )/ good$1/' $file
perl -i -p -e 's/ pekn[^$ \n]+(?=$| )/ nice/' $file
perl -i -p -e 's/ posledn[^$ ]+($| )/ last$1/' $file

# Place names
perl -i -p -e 's/Anglick.(?=$| )/England/' $file
perl -i -p -e 's/Amerik.(?=$| )/America/' $file
perl -i -p -e 's/Belgick.(?=$| )/Belgium/' $file
perl -i -p -e 's/Bielorusk.(?=$| )/Belarus/' $file
perl -i -p -e 's/Bosn.(?=$| )/Bosnia/' $file
perl -i -p -e 's/Veľk.[^\s]? Británi.(?=$| )/Great Britain/' $file
perl -i -p -e 's/Čiern.[^ ]? Hor.(?=$| )/Montenegro/' $file
perl -i -p -e 's/(?=^| )Belgick.(?=$| )/Belgium/' $file
perl -i -p -e 's/Česk.(?=$| )/Czechia/' $file
perl -i -p -e 's/Čiern. Hor.(?=$| )/Montenegro/' $file
perl -i -p -e 's/Čín(a|u|y)(?=$| )/China/' $file
perl -i -p -e 's/Estónsk.(?=$| )/Estonia/' $file
perl -i -p -e 's/Európ.(?=$| )/Europe/' $file
perl -i -p -e 's/Fínsk.(?=$| )/Finland/' $file
perl -i -p -e 's/Francúzsk.(?=$| )/France/' $file
perl -i -p -e 's/Gréck.(?=$| )/Greece/' $file
perl -i -p -e 's/Hercegovin.(?=$| )/Herzegovina/' $file
perl -i -p -e 's/Holandsk.(?=$| )/Holland/' $file
perl -i -p -e 's/Chorvátsk.(?=$| )/Croatia/' $file
perl -i -p -e 's/Írsk.(?=$| )/Ireland/' $file
perl -i -p -e 's/Japonsk.(?=$| )/Japan/' $file
perl -i -p -e 's/Kanad.(?=$| )/Canada/' $file
perl -i -p -e 's/Lichtenštajnsk.(?=$| )/Liechtenstein/' $file
perl -i -p -e 's/Litv.(?=$| )/Lithuania/' $file
perl -i -p -e 's/Lotyšsk.(?=$| )/Latvia/' $file
perl -i -p -e 's/Luxembursk.(?=$| )/Luxembourg/' $file
perl -i -p -e 's/Mexik.(?=$| )/Mexico/' $file
perl -i -p -e 's/Maďarsk.(?=$| )/Hungary/' $file
perl -i -p -e 's/Moldavsk.(?=$| )/Moldova/' $file
perl -i -p -e 's/Nemeck.(?=$| )/Germany/' $file
perl -i -p -e 's/Nórsk.(?=$| )/Norway/' $file
perl -i -p -e 's/Poľsk.(?=$| )/Poland/' $file
perl -i -p -e 's/Portugalsk.(?=$| )/Portugal/' $file
perl -i -p -e 's/Rakúsk[ao](?=$| )/Austria/' $file
perl -i -p -e 's/Rusko(?=$| )/Russia/' $file
perl -i -p -e 's/(from )Ruska(?=$| )/$1Russia/' $file
perl -i -p -e 's/Škótsk.(?=$| )/Scotland/' $file
perl -i -p -e 's/Slovensk.(?=$| )/Slovakia/' $file
perl -i -p -e 's/Slovinsk.(?=$| )/Slovenia/' $file
perl -i -p -e 's/Španielsk.(?=$| )/Spain/' $file
perl -i -p -e 's/Srbsk.(?=$| )/Serbia/' $file
perl -i -p -e 's/Švajčiarsk.(?=$| )/Switzerland/' $file
perl -i -p -e 's/Švédsk.(?=$| )/Sweden/' $file
perl -i -p -e 's/Taliansk.(?=$| )/Italy/' $file
perl -i -p -e 's/Tureck.(?=$| )/Turkey/' $file
perl -i -p -e 's/Ukrajin.(?=$| )/Ukraine/' $file
perl -i -p -e 's/Vatikán.?(?=$| )/the Vatican/' $file


# Place name adjectives
perl -i -p -e 's/ americk[^$ \n]+(?=$| )/ american/' $file
perl -i -p -e 's/ anglick[^$ \n]+(?=$| )/ english/' $file
perl -i -p -e 's/ belgick[^$ \n]+(?=$| )/ belgian/' $file
perl -i -p -e 's/ bielorusk[^$ \n]+(?=$| )/ belarusian/' $file
perl -i -p -e 's/ bosniansk[^$ \n]+(?=$| )/ bosnian/' $file
perl -i -p -e 's/ britsk[^$ \n]+(?=$| )/ british/' $file
perl -i -p -e 's/ česk[^$ \n]+(?=$| )/ czech/' $file
perl -i -p -e 's/ čiernohorsk[^$ \n]+(?=$| )/ montenegrin/' $file
perl -i -p -e 's/ čínsk[^$ \n]+(?=$| )/ chinese/' $file
perl -i -p -e 's/ estónsk[^$ \n]+(?=$| )/ estonian/' $file
perl -i -p -e 's/ fínsk[^$ \n]+(?=$| )/ finnish/' $file
perl -i -p -e 's/ francúzsk[^$ \n]+(?=$| )/ french/' $file
perl -i -p -e 's/ gréck[^$ \n]+(?=$| )/ greek/' $file
perl -i -p -e 's/ hercegovsk[^$ \n]+(?=$| )/ herzegovinian/' $file
perl -i -p -e 's/ holandsk[^$ \n]+(?=$| )/ dutch/' $file
perl -i -p -e 's/ chorvátsk[^$ \n]+(?=$| )/ croatian/' $file
perl -i -p -e 's/ írsk[^$ \n]+(?=$| )/ irish/' $file
perl -i -p -e 's/ japonsk[^$ \n]+(?=$| )/ japanese/' $file
perl -i -p -e 's/ kanadsk[^$ \n]+(?=$| )/ canadian/' $file
perl -i -p -e 's/ lichtenštajnsk[^$ \n]+(?=$| )/ liechtensteinish/' $file
perl -i -p -e 's/ litovsk[^$ \n]+(?=$| )/ lithuanian/' $file
perl -i -p -e 's/ lotyšsk[^$ \n]+(?=$| )/ latvian/' $file
perl -i -p -e 's/ luxembursk[^$ \n]+(?=$| )/ luxembourgish/' $file
perl -i -p -e 's/ macedónsk[^$ \n]+(?=$| )/ macedonian/' $file
perl -i -p -e 's/ maďarsk[^$ \n]+(?=$| )/ hungarian/' $file
perl -i -p -e 's/ mexick[^$ \n]+(?=$| )/ mexican/' $file
perl -i -p -e 's/ moldavsk[^$ \n]+(?=$| )/ moldavian/' $file
perl -i -p -e 's/ nemeck[^$ \n]+(?=$| )/ german/' $file
perl -i -p -e 's/ nórsk[^$ \n]+(?=$| )/ norwegian/' $file
perl -i -p -e 's/ poľsk[^$ \n]+(?=$| )/ polish/' $file
perl -i -p -e 's/ portugalsk[^$ \n]+(?=$| )/ portugese/' $file
perl -i -p -e 's/ rakúsk[^$ \n]+(?=$| )/ austrian/' $file
perl -i -p -e 's/ rusk[^$ \n]+(?=$| )/ russian/' $file
perl -i -p -e 's/ škótsk[^$ \n]+(?=$| )/ scottish/' $file
perl -i -p -e 's/ slovensk[^$ \n]+(?=$| )/ slovakian/' $file
perl -i -p -e 's/ slovinsk[^$ \n]+(?=$| )/ slovenian/' $file
perl -i -p -e 's/ španielsk[^$ \n]+(?=$| )/ spanish/' $file
perl -i -p -e 's/ srbsk[^$ \n]+(?=$| )/ serbian/' $file
perl -i -p -e 's/ švajčiarsk[^$ \n]+(?=$| )/ swiss/' $file
perl -i -p -e 's/ švédsk[^$ \n]+(?=$| )/ swedish/' $file
perl -i -p -e 's/ taliansk[^$ \n]+(?=$| )/ italian/' $file
perl -i -p -e 's/ tureck[^$ \n]+(?=$| )/ turkish/' $file
perl -i -p -e 's/ ukrajinsk[^$ \n]+(?=$| )/ ukranian/' $file
perl -i -p -e 's/ vatikánsk[^$ \n]+(?=$| )/ vatican/' $file

# Demonyms
perl -i -p -e 's/ Angličan(?=$| )/ an Englishman/' $file
perl -i -p -e 's/ Angličanka(?=$| )/ English/' $file
perl -i -p -e 's/ Angličani?(?=$| )/ Englishmen/' $file
perl -i -p -e 's/ Angličanky(?=$| )/ English/' $file
perl -i -p -e 's/ Američan(ka)?(?=$| )/ an American/' $file
perl -i -p -e 's/ Američan(i|ky)(?=$| )/ Americans/' $file
perl -i -p -e 's/ Belgičan(ka)?(?=$| )/ a Belgian/' $file
perl -i -p -e 's/ Belgičan(i|ky)(?=$| )/ Belgians/' $file
perl -i -p -e 's/ Bielorus(?=$| )/ a Belarusian/' $file
perl -i -p -e 's/ Bielorusi(?=$| )/ Belarusians/' $file
perl -i -p -e 's/ Bosnia(k|čka)(?=$| )/ a Bosnian/' $file
perl -i -p -e 's/ Bosnia(ki|čky)(?=$| )/ Bosnians/' $file
perl -i -p -e 's/ Brit(ka)?(?=$| )/ a brit/' $file
perl -i -p -e 's/ Brit(i|ky)(?=$| )/ brits/' $file
perl -i -p -e 's/ Če(ch|ška)(?=$| )/ a Czech/' $file
perl -i -p -e 's/ Če(chi|šky)(?=$| )/ Czechs/' $file
perl -i -p -e 's/ Čiernohor(ec|ka)(?=$| )/ a Montenegrin/' $file
perl -i -p -e 's/ Čiernohor(eci|ky)(?=$| )/ Montenegrins/' $file
perl -i -p -e 's/ Číňan(ka)?(?=$| )/ Chinese/' $file
perl -i -p -e 's/ Číňan(i|ky)(?=$| )/ Chinese/' $file
perl -i -p -e 's/ Estón(ec|ka)(?=$| )/ an Estonian/' $file
perl -i -p -e 's/ Estón(eci|ky)(?=$| )/ Estonians/' $file
perl -i -p -e 's/ Európanka(?=$| )/ a European/' $file
perl -i -p -e 's/ Európan(i|ky)(?=$| )/ Europeans/' $file
perl -i -p -e 's/ Fín(ka)?(?=$| )/ a Finn/' $file
perl -i -p -e 's/ Fín(i|ky)(?=$| )/ Finns/' $file
perl -i -p -e 's/ Francúz[^\n ]*(?=$| )/ French/' $file
perl -i -p -e 's/ Grék(yňa)?(?=$| )/ a Greek/' $file
perl -i -p -e 's/ Grék(i|yňe)(?=$| )/ Greeks/' $file
perl -i -p -e 's/ Hercegovin(ec|ka)(?=$| )/ a Herzegovinian/' $file
perl -i -p -e 's/ Hercegovin(eci|ky)(?=$| )/ Herzegovinians/' $file
perl -i -p -e 's/ Holanďan(ka)?(?=$| )/ Dutch/' $file
perl -i -p -e 's/ Holanďan(i|ky)(?=$| )/ Dutch/' $file
perl -i -p -e 's/ Chorvát(ka)?(?=$| )/ a Croat/' $file
perl -i -p -e 's/ Chorvát(i|ky)(?=$| )/ Croatians/' $file
perl -i -p -e 's/ Ír(?=$| )/ an Irishman/' $file
perl -i -p -e 's/ Írka(?=$| )/ an Irishwoman/' $file
perl -i -p -e 's/ Ír(i|ky)(?=$| )/ Irish/' $file
perl -i -p -e 's/ Japon(ec|ka)(?=$| )/ Japanese/' $file
perl -i -p -e 's/ Japon(eci|ky)(?=$| )/ Japanese/' $file
perl -i -p -e 's/ Kanaďan(ka)?(?=$| )/ a Canadian/' $file
perl -i -p -e 's/ Kanaďan(i|ky)(?=$| )/ Canadians/' $file
perl -i -p -e 's/ Lichtenštajnčan(ka)?(?=$| )/ a Liechtensteiner/' $file
perl -i -p -e 's/ Lichtenštajnčan(i|ky)(?=$| )/ Liechtensteiners/' $file
perl -i -p -e 's/ Litovčan(ka)?(?=$| )/ a Lithuanian/' $file
perl -i -p -e 's/ Litovčan(i|ky)(?=$| )/ Lithuanians/' $file
perl -i -p -e 's/ Lotyš(ka)?(?=$| )/ a Latvian/' $file
perl -i -p -e 's/ Lotyš(i|ky)(?=$| )/ Latvians/' $file
perl -i -p -e 's/ Luxemburčan(ka)(?=$| )/ a Luxembourger/' $file
perl -i -p -e 's/ Luxemburčan(i|k.)(?=$| )/ Luxembourgers/' $file
perl -i -p -e 's/ Macedón(ec|ka)(?=$| )/ a Macedonian/' $file
perl -i -p -e 's/ Macedón(eci|ky)(?=$| )/ Macedonians/' $file
perl -i -p -e 's/ Maďar(ka)?(?=$| )/ a Hungarian/' $file
perl -i -p -e 's/ Maďar(i|ky)(?=$| )/ Hungarians/' $file
perl -i -p -e 's/ Mexičan(ka)?(?=$| )/ a Mexican/' $file
perl -i -p -e 's/ Mexičan(i|ky)(?=$| )/ Mexicans/' $file
perl -i -p -e 's/ Moldavčan(ka)?(?=$| )/ a Moldavian/' $file
perl -i -p -e 's/ Moldavčan(i|ky)(?=$| )/ Moldavians/' $file
perl -i -p -e 's/ Nem(ec|ka)(?=$| )/ a German/' $file
perl -i -p -e 's/ Nem(ec|ky)(?=$| )/ a German/' $file
perl -i -p -e 's/ Nemeci(?=$| )/ Germans/' $file
perl -i -p -e 's/ Nór(ka)?(?=$| )/ a Norwegian/' $file
perl -i -p -e 's/ Nór(i|ky)(?=$| )/ Norwegians/' $file
perl -i -p -e 's/ (Poľka|Poliak)(?=$| )/ a Pole/' $file
perl -i -p -e 's/ (Poliaki|Poľky)(?=$| )/ Poles/' $file
perl -i -p -e 's/ Portugal(ec|ka)(?=$| )/ a Portugese/' $file
perl -i -p -e 's/ Portugal(eci|ky)(?=$| )/ Portugese/' $file
perl -i -p -e 's/ Rakúšan(ka)?(?=$| )/ an Austrian/' $file
perl -i -p -e 's/ Rakúšan[^ \n]*(?=$| )/ Austrians/' $file
perl -i -p -e 's/ Rus(ka)?(?=$| )/ a Russian/' $file
perl -i -p -e 's/ Rus(i|ky)(?=$| )/ Russians/' $file
perl -i -p -e 's/ Škót(ka)?(?=$| )/ a Scot/' $file
perl -i -p -e 's/ Škót(i|ky)(?=$| )/ Scots/' $file
perl -i -p -e 's/ Slov(ák|enka)(?=$| )/ a Slovak/' $file
perl -i -p -e 's/ (Slováki|Slovenky)(?=$| )/ Slovaks/' $file
perl -i -p -e 's/ Slovin(ec|ka)(?=$| )/ a Slovene/' $file
perl -i -p -e 's/ (Slovinky|Slovineci)(?=$| )/ Slovenians/' $file
perl -i -p -e 's/ Španiel(ka)?(?=$| )/ a Spaniard/' $file
perl -i -p -e 's/ Španiel(i|ky)(?=$| )/ Spaniards/' $file
perl -i -p -e 's/ Srb(ka)?(?=$| )/ a Serb/' $file
perl -i -p -e 's/ Srb(i|ky)(?=$| )/ Serbians/' $file
perl -i -p -e 's/ Švajčiar(ka)?(?=$| )/ Swiss/' $file
perl -i -p -e 's/ Švajčiar(i|ky)(?=$| )/ Swiss/' $file
perl -i -p -e 's/ Švéd(ka)?(?=$| )/ a Swede/' $file
perl -i -p -e 's/ Švéd(i|ky)(?=$| )/ Swedes/' $file
perl -i -p -e 's/ Talian(ka)?(?=$| )/ an Italian/' $file
perl -i -p -e 's/ Talian(i|ky)(?=$| )/ Italians/' $file
perl -i -p -e 's/ Ukrajin(ec|ka)(?=$| )/ a Ukranian/' $file
perl -i -p -e 's/ Ukrajin(eci|ky)(?=$| )/ Ukranians/' $file

# add article before singular adjectives, excluding "which" and "some"
perl -i -p -e 's/ have (?!which)(?!some)(.+)(?<!s)(?<!men)(?<!feet)$/ have a $1$2/' $file
# Since "class" ends in 's' is is incorrectly identified as plural by the preceeding line
perl -i -p -e 's/ have (?!which)(?!some)(.+)(class)$/ have a $1$2/' $file
perl -i -p -e 's/ a (a|i)/ an $1/' $file


# this one causes problem with 'ona nie je' -> 'she is not' becomes "she is a not'
#perl -i -p -e 's/ is (?!some)(?!which)/ is a /' $file
perl -i -p -e 's/ a such / such a /' $file

perl -i -p -e 's/ going via (.+)(?<!s)(?<!men)$/ going via a $1/' $file


perl -i -p -e 's/.*which.*/$&?/' $file
