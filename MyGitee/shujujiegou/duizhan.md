# 堆栈(后入先出)

受约束的线性表，只在一端做插入和删除

---

## 数组实现堆栈

### 堆栈操作函数

```C
#define MaxSize 100
typedef struct SNode *Stack;
struct SNode{
	ElementType Data[MaxSize];
	int Top; //表示栈顶数组元素的下标 
}

Stack CreatStack(int MaxSize); //生成空堆栈最大长度是MaxSize
int IsFull(Stack S,int MaxSize); //判断堆栈S 是否为空
void Push(Stack S,ElementType item); //将元素item压入堆栈
int IsEmpty(Stack S); //判断S是否为空
ElementType Pop(Stack S); //删除并返回栈顶元素
```
### 操作函数

```C
//置空栈，栈初始化，将Top初始化为-1
Stack SetNullS(Stack S){
	S->Top=-1;
	return S;
}
//判断栈是否为空
int EmptyS(Stack S){
	if(S->Top>=0) return 0;
	else return 1;
}
//入栈函数
void Push(Stack PtrS,ElementType item){
	  if(PsrS->Top==MaxSize-1){//堆栈满
        return;
    }else{
        PtrS->Data[++(PtrS->Top)]=item; //item放在Top上面的位置
        return;
    }
}
//出栈
ElementType Pop(Stack PtrS){
    if(PtrS->Top==-1){//堆栈空
        return ERROR;
        //ERROR是ElementType的特殊值，由用户自己设置，标志错误
    }else
        return (PtrS->Data[(PtrS->Top)--]);
}
//取栈顶元素而不改变Top的值
```

---
## 链表实现堆栈

