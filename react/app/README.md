# 使い方
## 起動
clone先のディレクトリから `docker compose up -d`
## URL
http://localhost:5173/{pageURL}
## 編集先
/app/src配下を触ります。
### ルーティング
App.tsx で URLのPathを指定可能です。
現在は以下2つが設定されています。
* 商品詳細：http://localhost:5173/productDetail
* カートページ：http://localhost:5173/cart
不足しているページについては、各々設定してください。
### ページ
/app/pagesの配下に格納してください。
現在は商品詳細とカートページのみ用意されています。
### コンポーネント
/app//componentの配下に格納してください。
本当はディレクトリ整理した方がいいのかもしれないのですが、一旦フラットで作っています。
### CSS
/app/assets/cssの配下に格納してください。
### 画像
/app/assets/imageの配下に格納してあるので自由に使ってください。
