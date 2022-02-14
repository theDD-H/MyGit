# 学习linux的一些指令 <鸟哥的linux私房菜>

---

- **编辑vim的配置文件 vim .vim/vimrc** 

- **tips:互换Cap和Esc的键位** 

	新建文件.xmodmap，写入如下几行，保存退出：

	        remove Lock = Caps_Lock

	        keycode 9 = Caps_Lock NoSymbol Caps_Lock

	        keycode 66 = Escape NoSymbol Escape

	        add Lock = Caps_Lock

	执行shell命令：xmodmap .xmodmap

---
---
## 1.简单程序

-	cal 显示日历

	-	cal 5 2022 显示2022年5月的日历

	-	cal 2022 显示2022年的日历

-	bc 一个简单的计算器

-	date 显示时间 包括年月日时间

-	天气预报 curl v2.wttr.in/dezhou (可以修改后面的地址,貌似只能精确到市)

---
## 2.文件和目录的操作

	- cd 切换目录 （cd 	cd ~ 	都是返回主目录的命令）

		- cd .. 返回上一级目录 (.此目录..上一层目录～家目录)

	- pwd 显示当前目录

		- pwd 显示目录 pwd -P显示完整的目录	

	- mkdir 创建新的文件

		- mkdir	文件名 直接创建

		- mkdir -p 文件1/文件2/文件3 创建多层

	- rmdir 删除文件

	- mv /bin/ls /root 将bin目录下的ls移动到root目录

---
## 3.文件路径变量 

	-echo $PATH 显示已经添加的变量

	-PATH="${PATH}:/root" 将路径添加到变量中

---
## 4.文件的复制删除与移动

-	-cp 复制文件

		- -cp -r a Downloads 将家目录下的a文件复制到downloads

		- -cp -r a Downloads/b 将家目录下的a文件复制到downloads并改名为b

		- -r 递归持续复制，用于目录的复制（常用）

		- -p 将文件的属性一同复制过去

		- -i 目标文件已经存在时，覆盖时会进行询问

		- -s 复制成为快捷方式文件 

-	rm 移除文件或目录

	- -f 文件名 忽略不存在的文件，不会出现警告信息

	- -i 删除之前会进行询问

	-	-r 递归删除，用于多层文件的删除（较危险）

- mv 移动文件、目录，或更名

	*格式同cp -f 强制模式，如果目标文件存在，不会询问直
    接覆盖* 

	- -i 目标文件存在，会进行询问

	-	-u 目标文件存在但是较早，会进行覆盖更新

	-	mv a b 将文件a命名b	

----

## 5.文件内容的查阅cat tac nl more less head tail od

- cat 从第一行开始显示文件内容 tac从下往上现实内容

	-	-n 文件  显示文件内容，空白行有行号

	-	-b 空白行无行号

	-	-E 结尾的换行字符$显示出来

	-	-T 将Tab显示出来

	-	-v 列出一些看不出来的字符

	-	-A -vET的总和

- nl 添加行号进行打印


**以上命令都是一次性将内容全部显示，不利于查看**

---

- more（一页一页翻动）	

	- 空格 翻一页

	- b 往回翻页  

	- 回车 翻一行

	- /字符串 向下搜寻

	- :f 显示文件名以及当前的行数

	- q 退出

- less 比more更加高级 （可用pageup pagedown键进行翻页）

	- 	/字符串 向下搜寻  ?字符串向上搜寻

	- 	n重复前一个搜寻 N反向重复前一个搜寻

	- 	g前进第一行 G到最后一行

	- 	q 退出

-----
## 6.资料摘取

-	head 取出前面几行

	-	head 文件 默认显示10行

	-	head -n 20 文件 显示文件前20行

	-	head -n -100 文件 后面100行不显示，只显示前面几行

-	tail 取出后面几行

	-	tail 文件 默认后面10行

	-	tail -n 20 文件 后面20行

	-	tail -n +100 文件 不知道文件有多少，只想显示100行以后的内容

-	od 非纯文本文档

	-	-t a 默认字符输出

	-	-t c ASCII字符输出

	-	-t d[size] 利用十进制输出数据，每个整数占用size bytes

	-	-t f[size] 浮点数输出数据。。。。。

	-	-t o[size] 八进制。。。。。

	-	-t x[size] 十六进制。。。。。


---
## 7.修改文件时间建立新档 touch	

	-	-a 修订access time

	-	-c 只修改文件时间，若文件不存在不建立新的文件


---
## 8.观察文件类型 file 指令： file 文件	

---
# 9.指令与文件的搜寻

-	which 寻找【执行档】

	-	which -a command 将所有可执行的命令列出

	-	whereis 在特定的目录寻找文件文件名

	-	locate updatedb命令进行更新可以输入文件名的部分来进行搜寻(ubuntu没有该命令)

	-	-i 忽略大小写差异

	-	-l 控制搜索结果输出多少行


*find 与上面两种相比，这个更慢但是完整 格式很多，但是我仔细看*
---



