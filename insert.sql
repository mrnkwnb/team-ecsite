SET foreign_key_checks=1;

USE utopiadb;

INSERT INTO mst_user(user_name,password,family_name,first_name,family_name_kana,first_name_kana,gender) VALUES ('yamada@gmail.com','123','山田','太郎','やまだ','たろう',0);

INSERT INTO mst_category (category_name)VALUES
('トップス'),
('ボトムス'),
('シューズ');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES
('ショート丈ニット','しょーとたけにっと','立体的な編み込みデザインが目を引く。柔らかなニット素材にお花モチーフのボタンがフェミニンな雰囲気に♡',1,2500,'/img/tops/knit.jpg','2022/12/29','(株)utopia'),
('ピンタックブラウス','ぴんたっくぶらうす','とろみのあるレーヨン素材で上品に着こなせます。ピンタックや袖口のギャザーでフェミニンな雰囲気に♡',1,3000,'/img/tops/blouse.jpg','2022/12/29','(株)utopia'),
('デニムワイドパンツ','でにむわいどぱんつ','ゆったりとした親しみやすいシルエットが魅力のデニムワイドパンツ。トップスインでデニムを主役にしたスタイリングが楽しめます。落ち着いたカラーは、大人カジュアルなスタイリングにぴったり！',2,5000,'/img/bottom/pants.jpg','2022/12/29','(株)utopia'),
('タイトスカート','たいとすかーと','エレガントなタイトスカート。環境への影響を軽減した原材料と技術によって製造されています。',2,3500,'/img/bottom/skirt.jpg','2022/12/29','(株)utopia'),
('ローカットスニーカー','ろーかっとすにーかー','シンプルで使い勝手の良いスニーカー。大きめなソールが程よいボリューム感を足元に与えてくれます☆',3,2900,'/img/shoes/sneakers.jpg','2022/12/29','(株)utopia'),
('ポインテッドトゥパンプス','ぽいんてっどとぅぱんぷす','シュッと尖ったつま先は足元を美しく見せる効果があり、大人っぽく仕上げたいときにぴったりです！',3,2700,'/img/shoes/pump_shoes.jpg','2022/12/29','(株)utopia');