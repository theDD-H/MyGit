# This is my Python learn note.

## 注释

```
"""
多行注释的添加方法
"""

'''
多行注释对于也可以用单引号
'''

# 是单行注释
# 注释也可以加到每一行的后面
```

TODO注释
> # TODO 注释 会可添加需要做的事 及时提醒我们

## 一些符号

// 代表取整除法

% 代表取余除法

** 代表乘方

## Python中变量的定义不需要定义类型，直接赋值即可

## print和input

input是输入函数，他收到的都是str类型

用法 passwad = input("提示信息")  提示信息可不加

可用type（）来查看类型

> passwad = input("请输入密码")

类型转换函数 int（被转换） float（被转)

> print(float(input("单价")) * float(input("重量")))


### print的格式化输出
> print("问题%s" % st)

> print("问题%s 第二个%d" % (st, a))

%06 显示6位，不足的用0。超过6位正常显示

%.02f 小数点后两位

%% 显示%

%d 打印十进制 
%x 打印十六进制

> print 在输出时会自动进行换行
 
> print("") 表示单纯的换行
 
> print("xxx",end="") 这样才不会换行
 
> print("xxx",end="---") 会在末尾输出---

### 转义字符
> print("\n") 换行
 
>print("\t") 制表符 辅助输出时垂直对齐

有一些特殊字符 如" 可以用\"来辅助输出

> st = "aaaa"

> a = 6666

 
> print("问题%s" % st)
> 
> print("问题%s 第二个%d" % (st, a))

## import关键字可以导入一个工具包

> import keyword

查看工具包关键字的内容

> print(keyword.kwlist)
> 
> 
## import random 导入随机数工具包

> random.randint(10 , 20) 产生10-20的数（包括10和20）

> random.randint(10 , 10) 产生的数一直是10

> random.randint(20 , 10) 格式错误

## 循环

>python中只有while

>while 判断:

>	语句（注意缩进）

~~for 循环主要用来遍历集合~~ 

## 判断

```
if 判断:
	
	语句

elif 判断:

	语句

else
	
	语句
```

## pass关键字

不希望立刻编写分支内部的代码，
可以用pass来占行。

## 函数

可以新建一个py文件，然后在开头加入

```python
def 函数名():

	语句1

	语句2

	...

```
如果在别的文件使用

需要import 该文件(不需要添加后缀.py)

调用： 文件名.xxxx

## 数组

直接定义

> name=["zhangsan","lisi","wangwu"]
>
> number=[1 , 2 , 3]

调用数组处理函数

数组变量.函数名   调用函数

~~一个数组中可以包含多种类型的变量，但是不提倡~~

> list=["zhansghan",18,1 .75]

调用方法

> list[0]........等等

循环遍历数组中的元素

>for name in name_list:
>
>	print(name)



## 元组

类似于数组，但是里面的变量不可以修改，可以保存多种类型的数据

定义方法

> info_tuple = ("小明", 21, 1.85)

元组的调用方法和数组的一样，可任意通过索引

> print("%s 年龄是 %d 身高是 %.2f " % info_tuple)
> 等价于
> print(info_tuple)

创建空元组

> info_tuple = ()

没有啥用，因为创建之后就不能修改 

当元组中只包含一个元素时，应在元素后面加上逗号

> info_tuple = (50, )

## 字典

创建字典

> xiaoming = {"name":"小明",
>
> 			"age":18,
>
> 			"heiget":1.75}

前面的引号代表key值，代表索引，后面是数据，key必须是唯一的

调用方法 调用时key不能输入错误，否则报错

> print(xiaoming["name"])

修改和添加
>#修改
>
> xiaoming["name"] = "123123"
>
>#添加新的数据
>
> xiaoming["age"] = 18

删除
> xiaoming.pop("name")

> print(xiaoming) #会把key和数据都打印出来

len(字典) 可以统计key值的数量

合并字典

> xiaoming.update(新的字典)

若key值重复，则储存最新的key

清空字典
> xiaoming.clear()

遍历字典 字典里面有多种类型的数据

```python
xiaoming = {"name":"xiaoming",
			"qq":"123123",
			"phone":"10086"}
for k in xiaoming:

	print("%s - %s" % (k, xiaoming[k]))
``` 
将字典存到数组中
```python
list = [
		{"name":"xiaoming",
		"age":"18"},
		{"name":"zhangsan",
		"age":"22"}
]
#循环遍历
for tt in list:

	print(tt)
```

---
## 一些函数

| 关键字                  | 说明                     |
|-------------------------|--------------------------|
| 列表.insert(索引,数据)  | 在指定位置插入数据       |
| 列表.qppend(数据)       | 在末尾追加数据           |
| 列表.extend(列表2)      | 将列表2的数据追加到列表  |
|-------------------------|--------------------------|
| 列表[索引]=数据         | 修改制定索引的数据       |
|-------------------------|--------------------------|
| del 列表[索引]          | 删除指定索引的数据       |
| 列表.remove[数据]       | 删除第一个出现的制定数据 |
| 列表.pop                | 删除末尾数据             |
| 列表.pop(索引)          | 删除指定索引的数据       |
| 列表.clear              | 清空列表                 |
| len(列表)               | 列表长度                 |
| 列表.count(数据)        | 数据在列表中出现的次数   |
|-------------------------|--------------------------|
| 列表.sort()             | 升序排序                 |
| 列表.sort(reverse=True) | 降序排序                 |
| 列表.reverse()          | 逆序，反转               |
|-------------------------|--------------------------|
---

## 字符串

在python中，字符串可以用双引号或者是单引号，
但是为了和其他语言保持一致，一般是双引号，
当字符串中包含双引号的时候，采用单引号：

str = ‘你好啊，我叫"xxx"’

这样才会把双引号添加到字符串中。

---

输出字符串的特定某个数据
> str = "hello python"

> print(str[6])

> 则此项输出结果为p

### 字符串函数
#### 判断类型

| 函数               | 说明                                                 |
|--------------------|------------------------------------------------------|
| string.isspace()   | 只包含空格，则返回true                               |
| string.isalnum()   | 至少有一个字符且都是字母或者数字，则返回true         |
| string.isalpha()   | 至少有一个字符且所有字符都是字母，则返回true         |
| sring.isdecimal()  | 只包含数字返回true,全角数字                          |
| string.isdigit()   | 只包含数字返回true，全角数字、(1)、\u00b2（平方的2） |
| string.isnumeric() | 只包含数字返回true，全角数字、汉字数字               |
| string.istitle()   | string是标题化的（每个单词的首字母大写）返回true     |
| string.islower()   | 所有可以区分大小写的字符都是小写的返回true           |
| string.isupper()   | 判断大写                                             |

#### 查找和替换

| 函数                                                  | 说明                                        |
|-------------------------------------------------------|---------------------------------------------|
| string.startswith(str)                                | 以str开头，返回true                         |
| string.endswith(str)                                  | 以str结尾，返回true                         |
| string.find(str,start=0,end=len(string))              | str是否在制定范围中，如果有返回索引，否则-1 |
| string.rfind(str,start=0,end=len(string))             | 类似于find()，不过是从右边开始查找          |
| string.index(str,start=0,end=len(string))             | 类似于find(),但是不存在str会报错            |
| string.rindex(str,start=0,end=len(string))            | 类似于index(),不过是从右边开始              |
| string.replace(old_str,new_str,num=string.count(old)) | 替换字符串，如果num制定，则限制次数         |

#### 大小写转换


| 函数                | 说明                       |
|---------------------|----------------------------|
| string.capitalize() | 字符串第一个字符大写       |
| string.title()      | 字符串的每个单词首字母大写 |
| string.lower()      | 所有大写为小写             |
| string.upper()      | 所有小写字母大写           |
| string.swapcase()   | 翻转大小写                 |

#### 去除空白字符


| 函数            | 说明                   |
|-----------------|------------------------|
| string.lstrip() | 截掉左边开始的空白字符 |
| string.rstrip() | 截掉右边的空白字符     |
| string.strip()  | 截掉左右两边的空白字符 |

#### 拆分和连接

| 函数                     | 说明                                                         |
|--------------------------|--------------------------------------------------------------|
| string.partition(str)    | 分成3元素的元组（str前面、str、str后面）                     |
| string.rpartition(str)   | 类似与上个函数，只不过是从右边开始查找str                    |
| string.split(str="",num) | 以str为分隔符，可以指定num制定值，str默认包括\t \n \r 和空格 |
| string.splitlines()      | 按照\t\n\r分割，返回列表                                     |
| string.join(seq)         | 以string为分隔符，将seq的所有元素合并为新的字符串            |

>string.join(seq)的 举例
>
>result = "".join(str_list)

## 公共方法

### 内置函数


| 函数             | 描述                       | 备注                    |
|------------------|----------------------------|-------------------------|
| len(item)        | 计算容器中元素的个数       |                         |
| del(item)        | 删除变量                   |                         |
| max(item)        | 返回容器中元素最大值       | 如果是字典，只比较key值 |
| min(item)        | 返回最小值                 | 同上                    |
| cmp(item1,item2) | 比较，-1小于，0等于，1大于 | python3.0取消了cmp函数  |

### 切片

| 描述 | python表达式       | 结果    | 支持的数据类型     |
|------|--------------------|---------|--------------------|
| 切片 | "0123456789"[::-2] | "97531" | 字符串，列表，元组 |

"0123456789"[::] 参数分别为：起始索引，结束索引，步长

步长可指定正负值，正为从左往右，负为从右往左

### 运算符


| 运算符       | 表达式           | 结果             | 描述         | 支持的数据类型                          |
|--------------|------------------|------------------|--------------|-----------------------------------------|
| +            | [1,2]+[3,4]      | [1,2,3,4]        | 合并         | 字符串、列表、元组                      |
| *            | ["hi"]*3         | ["hi","hi","hi"] | 重复         | 字符串、列表、元组                      |
| in           | 3 in (1,2,3)     | true             | 元素是否存在(可以用在if中) | 字符串、列表、元组、字典(只是判断key值) |
| not in       | 4 not in (1,2,3) | 类似上           | 类似上       | 类似上                                  |
| < > >= <= == | 元素比较         | ...              | ...          | ...                                     |

### 完整的for循环语法
 
 ```
 for 变量 in 集合:
	循环体代码
else ：
	没有通过break退出循环，完整循环结束后，会执行的代码
 ```
 遍历完成之后，else下面的代码才会被执行

 如果循环之中有break，那么else的不会被执行

## 让python文件可执行

在主程序文件开头加上

> #! /usr/bin/python3

上面的路径是解释器的路径

可以用which python3查看具体位置

然后chmod +x 给文件增加可执行权限

## 局部变量 全局变量

全局变量在函数中一般无法修改，需要在函数中用global声明

```python
num = 10

def fc1():
	
	num = 100 #这样并不会修改全局变量 只是创建局部变量

	# 正确方法

	global num
	num = 1

```

**定义全局变量应在调用函数的下面，否则无法识别** 

### 在一个变量名按shift+\<F6> 会一同修改一样的变量

### 函数返回值

直接在函数的末尾添加return即可

可以使用元组，让函数一次返回多个数值 return (元素,元素)

如果函数返回的类型是元素，可以省略小括号 return 元素,元素


```python
# 定义函数
# 也可以使用多个参数来接受函数返回值

def fc():
	a = 100
	b = 99
	return a,b

# 变量数量应该和函数返回值保持一样
num1,num2 = fc()
```

### 带参数函数

```python
def fc(num):
#函数中传参(变量、数组等)后赋值，不会修改原值	
```

```python
def fc(num_list):
	# 传递的参数是可变数据类型，且在函数中使用“方法”修改了内容
	# 则原始数据也会改变
	num_list.append(9) # 在数组末尾追加
	# 此方法会改变数组的值
```

### 递归函数的调用，需要有函数的出口（满足某个条件退出函数）

### 函数多值参数

*一个函数能够处理的参数个数有时候不确定，所以用到了多值参数*

>*参数名可以接受元组 

>**参数名 可以接受字典
```python
def fc(num, *nums, **kwargs):

fc(1,2,3,4,name="xiaoming",age=18)
# num=1
# nums=(2,3,4)
# kwargs={'name':'xiaoming','age':18}
fc(1) # 这种情况下只传递一个参数也是可以的
# num=1
# nums=()
# kwargs={}



def fc(*args,**kwargs):

# 分别定义元组和字典
args=(1,2,3)
kwargs={"name":"xiaoming","age":18}
fc(args,kwargs) # 这样调用只会将这两个传递到第一个元组中
fc(*args,**kwargs) # 这样才会分别传递
```


### 函数的缺省参数

**该缺省参数必须在整个函数定义的末尾** 

**一个函数中缺省参数可以有多个，都需要在末尾** 

```python
def fc(name ,num = 1):
	# 该函数的参数num为缺省参数
	# 如果调用的时候，不传递该参数，则默认num=1
	pass
	# 调用函数时，如果函数有多个缺省参数，给其中某个赋值
def fc(name,title="aaa",num=1):
	pass
# 调用该函数
fc("xiaoming",num=10)
# 这样可以给某个特定的参数传参
```

## 如果是列表变量进行“+=”，则调用extend方法（把另外一个列表整合到当前列表中）
如果是 list = list + list 则不会修改原始值
## 交换两个变量的值

```python
# 方法1 临时变量
 t = a
 a = b
 b = t
# 方法2 两个变量
a = a + b
b = a - b
a = a - b
# 方法3 python独有
a,b=b,a
```


---
---
---
# 面向对象的编程 <类和对象>

如果没有父类
> class 类名(object):
>
>	pass

```python
# 定义类 类名一般满足大驼峰命名法（每个单词首字母大写）
class 类名:
	
	# 函数的第一个参数必须是self（必须有self，且self在第一位。可以不定义别的参数）
	def fc(self,参数列表):
		pass

# 创建对象
对象变量 = 类名()
# 执行方法
对象变量.方法()
# 直接赋值不改变
对象变量2 = 对象变量1 # 此时2和1是同一个
```

### 设置对象属性
```python
# 在类的外部给对象增加属性 （不提倡）
对象变量.name = "xiaoming" # 这样可以直接创建属性
# 这样只是给某一个对象添加了属性
# 设置属性的代码要在用到的函数的上面，否则会报错
```

### self 的用法
```python
# self的用法 (self即为创建的对象的引用,不同对象的self不同)
class Cat:
	
	# 函数的第一个参数必须是self（必须有self，可以不定义别的参数）
	def fc(self,参数列表):
		print("%s 爱吃鱼" % self.name)

# 创建对象
tom = Cat()
# 添加属性
tom.name = "tom"
# 调用方法
tom.fc()
# 输出结果
>>> tom 爱吃鱼
```

### 对象属性初始化方法
```python
class Cat:
	def __init__(self):
		# 可以用来定义属性 具有局限性
		print("这是一个初始化方法，在变量定义时自动调用")
		# 这样会在变量定义时默认命名为xiaoming
		self.name="xiaoming"
------------------------------------------------------------------
	def __init__(self,new_name):
		self.name = new_name
		self.xxx = None # 此时不知道赋值，暂时None

# 定义
tom = Cat("Tom")
```

```python
# __del__ 对象在内存中被销毁，会自动调用该方法
# 可以使用del tom 来删除对象
# 否则在程序的末尾自动删除对象

# __str__必须返回一个字符串（该方法可以控制print的输出）
#  print(对象) 默认输出地址等信息
# 使用__str__可修改输出内容
```

### 一个对象的属性可以使另一个类创建的对象

```python
class Gun:

class People:

	def __init__(self):
		self.gun=None # 此时不知道赋值，暂时None
		# 判断时可用is进行判断是否为None

# 创建枪class
ak47=Gun()
# 创建人class
xiaoming=People()

xiaoming.gun=ak47 # 一个对象的属性可以使另一个类创建的对象

### 调用的时候可以 self.gun.方法 来调用gun的方法
```

### is运算符

可以比较两个的地址是否一样

| 形式       | 类似           |
|------------|----------------|
| x is y     | id(x) == id(y) |
| x is not y | id(x) != id(y) |

## 私有属性，私有方法->只能在对象内部调用的属性和方法

> 创建方式：在属性和方法前加两个下划线 __属性 __方法
>
> print(xiaofang.__age) 该函数是不允许的，因为__age是私有属性
>
> xiaofang.方法 对象的方法可以访问内部的私有属性
>
> 如果是私有方法 xiaofang.__方法() 这是不被允许的
>
> 访问私有属性和方法的处理 
> 
> 格式： \_类名__私有方法和属性 
> 
> print(xiaofang._类名__age)

---
---
---

## 继承 实现代码的重用，相同的代码不需要重复编写

```python
# 继承的语法
class 类名(父类名):
	pass
# 子类已经有了父类中所有的属性和方法
# 只要对特有的方法进行编写即可
# 子类的子类仍可以调用方法
# 子类可以重写父类的方法  调用后，只会调用重写的方法
```

```python
# 重写父类方法 实现既有新的方法又有父类方法 
class Dog:
	def bark():
		pass

class Xiaotianquan(Dog):
	def bark(): # 重写父类方法
		# 1.可以编辑新的代码
		pass
		# 2.调用父类源函数代码
		super().bark() # 或者是 “父类名.方法(self)” self必须传递 这种不提倡
		# 3.增加其他代码
		pass
```

子类不能调用父类的私有属性和方法

子类的方法也不能直接访问父类的私有属性和方法
```python
class A:
	def __init__(self):
		self.num = 100
	def __fc(self):
		pass

class B(A):
	def fc():
		
# 可以用父类的公共方法访问私有方法 然后子类调用父类的公共方法 实现间接访问私有 

```

###  多继承 子类可以有多个父类
```python
# 让子类对象同时具有多个父类的属性和方法
class zilei(fulei1, fulei2, ...):
	pass

# 如果多个父类有同名函数，会优先调用在前面的父类函数
```
### 如果没有父类，建议“class lei(object):”这样在2.x和3.x上都能运行
---

##  多态->不同的子类对象调用相同的父类方法产生不同的结果

以继承和重写父类方法为前提


```python
# 实例
class Tools(object):
	# 创建类属性，记录该类所创建的对象总数
	count = 0

	def __init__(self, name):
		self.name = name

		# 实现总数+1 注意是Tools
		Tools.count += 1

tool1 = Tools("剪刀")
tool2 = Tools("锤子")

# 也可以通过类对象来访问类属性（即上面的count）
# 类名.类属性 
# 对象名.类属性（不推荐）
# 对象属性和类名属性不是同一个值，注意区分
```

### 类方法 
 
```python 
@classmethod # 告诉解释器这是一个类方法
def 类方法名(cls): 
# 第一个参数cls是必须的，类似于self。cls.xxx 可以直接引用类对象或者类方法
	print("%d"% cls.count) # 访问传递的类的属性
	pass
```

```python
# 实例
class Tools(object):
	# 创建类属性，记录该类所创建的对象总数
	count = 0
	
	@classmethod # 告诉解释器这是一个类方法
	def show_count(cls): 
		print("%d"% cls.count) 

	def __init__(self, name):
		self.name = name

		# 实现总数+1 注意是Tools
		Tools.count += 1

tool1 = Tools("剪刀")
tool2 = Tools("锤子")

# 调用类方法
Tool.show_count() # 哪一个类调用，第一个参数就是哪一个，不需要传递参数

```

















