# Chaser
たばこ，お酒，カフェインの摂取を記録するためのAndroidアプリ

## What I want to do...
- たばこ，お酒，カフェインは日本で合法な嗜好品としてのドラッグであるが，これらの使用量を記録するための仕組みがほしい．
- まずはたばこからできるようにして，後々機能を増やす
- Google Play Storeにアップロードする

## Development with
- 縦横両方のマルチモジュールによる開発
- Roomを用いた開発
- Kotlin Coroutinesによる非同期処理
- DaggerによるDI
- Navigation Architecture Componentによる画面遷移

## Features
とにかく初期設定をなくしたい．
ただし，たばことか吸わない人がいるかもだから，適宜消せるようにはしたい．

### Alcohol
量を入力するのは面倒くさいので，とりあえずその日飲みましたという記録だけをつけたい

### Caffeine
RedBull，Monster，Coffeeボタンが有り，それぞれ押せるようにしたら良さそう

## Progression
### 2020-03-28
- 名前を考えた
- 空のプロジェクトを作成
- `:app`，`core`，`data`とモジュールを切った
    - `core`に入れる`:android`と`:model`を実装
    - `data`に入れる`:repository`と`:rpository-impl`を実装
        - その際に，DaggerでRepositoryを解決したいため，`:app`モジュールは`:repository-impl`を知っている構造になってしまった
        - また，`:app`内で何故か`:core:model`と`:data:*`の中に入っているオブジェクトが解決できず，unresolved referenceでコンパイルエラーになってしまっている

### 2020-03-29
- 結局unresolved referenceの原因は`build.gradle`に`apply plugin: "kotlin-android"`を書き忘れていたことであったことが判明．
- Threetenにも何故かZoneが登録されていないとか言って怒られたが，これは`AndroidThreeTen.init(this)`を`Application`で行う必要があった．
- BottomNavigationを追加（このとき，materialも追加）
- Navigation Architecture Componentsの依存関係を追加
- CigaretteFragmentを追加してDaggerのModuleを作ったが，何故かdependencies could be resolvedになってAppComponentsが作成できない

### 2020-03-30
- Daggerがdependencies could not be resolvedになるのは`:feature:home`にDaggerのapt系のDependenciesが追加されていないことが原因だった
