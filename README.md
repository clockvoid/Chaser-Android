# Chaser
$B$?$P$3!$$*<r!$%+%U%'%$%s$N@]<h$r5-O?$9$k$?$a$N(BAndroid$B%"%W%j(B

## What I want to do...
- $B$?$P$3!$$*<r!$%+%U%'%$%s$OF|K\$G9gK!$JSO9%IJ$H$7$F$N%I%i%C%0$G$"$k$,!$$3$l$i$N;HMQNL$r5-O?$9$k$?$a$N;EAH$_$,$[$7$$!%(B
- $B$^$:$O$?$P$3$+$i$G$-$k$h$&$K$7$F!$8e!95!G=$rA}$d$9(B
- Google Play Store$B$K%"%C%W%m!<%I$9$k(B

## Development with
- $B=D2#N>J}$N%^%k%A%b%8%e!<%k$K$h$k3+H/(B
- Room$B$rMQ$$$?3+H/(B
- Kotlin Coroutines$B$K$h$kHsF14|=hM}(B
- Dagger$B$K$h$k(BDI
- Navigation Architecture Component$B$K$h$k2hLLA+0\(B

## Features
$B$H$K$+$/=i4|@_Dj$r$J$/$7$?$$!%(B
$B$?$@$7!$$?$P$3$H$+5[$o$J$$?M$,$$$k$+$b$@$+$i!$E,59>C$;$k$h$&$K$O$7$?$$!%(B

### Alcohol
$BNL$rF~NO$9$k$N$OLLE]$/$5$$$N$G!$$H$j$"$($:$=$NF|0{$_$^$7$?$H$$$&5-O?$@$1$r$D$1$?$$(B

### Caffeine
RedBull$B!$(BMonster$B!$(BCoffee$B%\%?%s$,M-$j!$$=$l$>$l2!$;$k$h$&$K$7$?$iNI$5$=$&(B

## Progression
### 2020-03-28
- $BL>A0$r9M$($?(B
- $B6u$N%W%m%8%'%/%H$r:n@.(B
- `:app`$B!$(B`core`$B!$(B`data`$B$H%b%8%e!<%k$r@Z$C$?(B
    - `core`$B$KF~$l$k(B`:android`$B$H(B`:model`$B$r<BAu(B
    - `data`$B$KF~$l$k(B`:repository`$B$H(B`:rpository-impl`$B$r<BAu(B
        - $B$=$N:]$K!$(BDagger$B$G(BRepository$B$r2r7h$7$?$$$?$a!$(B`:app`$B%b%8%e!<%k$O(B`:repository-impl`$B$rCN$C$F$$$k9=B$$K$J$C$F$7$^$C$?(B
        - $B$^$?!$(B`:app`$BFb$G2?8N$+(B`:core:model`$B$H(B`:data:*`$B$NCf$KF~$C$F$$$k%*%V%8%'%/%H$,2r7h$G$-$:!$(Bunresolved reference$B$G%3%s%Q%$%k%(%i!<$K$J$C$F$7$^$C$F$$$k(B

### 2020-03-29
- $B7k6I(Bunresolved reference$B$N860x$O(B`build.gradle`$B$K(B`apply plugin: "kotlin-android"`$B$r=q$-K:$l$F$$$?$3$H$G$"$C$?$3$H$,H=L@!%(B
- Threeten$B$K$b2?8N$+(BZone$B$,EPO?$5$l$F$$$J$$$H$+8@$C$FE\$i$l$?$,!$$3$l$O(B`AndroidThreeTen.init(this)`$B$r(B`Application`$B$G9T$&I,MW$,$"$C$?!%(B
- BottomNavigation$B$rDI2C!J$3$N$H$-!$(Bmaterial$B$bDI2C!K(B
- Navigation Architecture Components$B$N0MB84X78$rDI2C(B
- CigaretteFragment$B$rDI2C$7$F(BDagger$B$N(BModule$B$r:n$C$?$,!$2?8N$+(Bdependencies could be resolved$B$K$J$C$F(BAppComponents$B$,:n@.$G$-$J$$(B

### 2020-03-30
- Dagger$B$,(Bdependencies could not be resolved$B$K$J$k$N$O(B`:feature:home`$B$K(BDagger$B$N(Bapt$B7O$N(BDependencies$B$,DI2C$5$l$F$$$J$$$3$H$,860x$@$C$?(B
