import java.io.*;
import java.util.*;

// 算式接口
interface IEqualtion extends Serializable {
    // 获取操作数1
    short getOperand1();
    // 设置操作数1
    void setOperand1(short operand1);

    // 获取操作数2
    short getOperand2();
    // 设置操作数2
    void setOperand2(short operand2);

    // 获取操作符
    char getOperator();
    // 设置操作符
    void setOperator(char operator);

    // 计算算式结果
    int calculate();
}

// 算式抽象类
abstract class AbstractEquation implements IEqualtion {
    private short operand1;
    private short operand2;
    private char operator;

    // 构造函数
    public AbstractEquation(short operand1, short operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    // 获取操作数1
    @Override
    public short getOperand1() {
        return operand1;
    }

    // 设置操作数1
    @Override
    public void setOperand1(short operand1) {
        this.operand1 = operand1;
    }

    // 获取操作数2
    @Override
    public short getOperand2() {
        return operand2;
    }

    // 设置操作数2
    @Override
    public void setOperand2(short operand2) {
        this.operand2 = operand2;
    }

    // 获取操作符
    @Override
    public char getOperator() {
        return operator;
    }

    // 设置操作符
    @Override
    public void setOperator(char operator) {
        this.operator = operator;
    }

    // 抽象方法，子类需实现计算逻辑
    @Override
    public abstract int calculate();

    // 重写equals方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEquation equation = (AbstractEquation) obj;
        return operand1 == equation.operand1 &&
                operand2 == equation.operand2 &&
                operator == equation.operator;
    }

    // 重写hashCode方法
    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operator);
    }
}

// 加法算式类
class AddEquation extends AbstractEquation {
    // 构造函数
    public AddEquation(short operand1, short operand2) {
        super(operand1, operand2, '+');
    }

    // 计算加法结果
    @Override
    public int calculate() {
        return getOperand1() + getOperand2();
    }

    // 静态内部类，用于构造模式
    static class AddEquationBuilder {
        private short operand1;
        private short operand2;

        // 设置操作数1
        AddEquationBuilder setOperand1(short operand1) {
            this.operand1 = operand1;
            return this;
        }

        // 设置操作数2
        AddEquationBuilder setOperand2(short operand2) {
            this.operand2 = operand2;
            return this;
        }

        // 构建AddEquation实例
        AddEquation build() {
            return new AddEquation(operand1, operand2);
        }
    }
}

// 减法算式类
class SubEquation extends AbstractEquation {
    // 构造函数
    public SubEquation(short operand1, short operand2) {
        super(operand1, operand2, '-');
    }

    // 计算减法结果
    @Override
    public int calculate() {
        return getOperand1() - getOperand2();
    }

    // 静态内部类，用于构造模式
    static class SubEquationBuilder {
        private short operand1;
        private short operand2;

        // 设置操作数1
        SubEquationBuilder setOperand1(short operand1) {
            this.operand1 = operand1;
            return this;
        }

        // 设置操作数2
        SubEquationBuilder setOperand2(short operand2) {
            this.operand2 = operand2;
            return this;
        }

        // 构建SubEquation实例
        SubEquation build() {
            return new SubEquation(operand1, operand2);
        }
    }
}

// 算式约束接口
interface EquationChecker {
    // 检查算式是否满足约束条件
    boolean check(IEqualtion equation);
}

// 实现算式约束接口的类
class EquationCheckerOfRange implements EquationChecker, Serializable {
    private int min;
    private int max;

    // 构造函数
    public EquationCheckerOfRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    // 检查算式是否满足范围约束条件
    @Override
    public boolean check(IEqualtion equation) {
        return equation.getOperand1() >= min && equation.getOperand1() <= max &&
                equation.getOperand2() >= min && equation.getOperand2() <= max &&
                equation.calculate() >= min && equation.calculate() <= max;
    }
}

// 算式产生类
class EquationGenerator {
    private static final EquationGenerator instance = new EquationGenerator();

    private EquationGenerator() {
    }

    // 获取EquationGenerator实例
    public static EquationGenerator getInstance() {
        return instance;
    }

    // 生成满足约束条件的算式列表
    public List<IEqualtion> generate(int n, EquationChecker checker) {
        Set<IEqualtion> equationSet = new HashSet<>();
        Random random = new Random();

        while (equationSet.size() < n) {
            equationSet.add(generateRandomEquation(random));
        }

        return new ArrayList<>(equationSet);
    }

    // 生成随机算式
    IEqualtion generateRandomEquation(Random random) {
        char operator = random.nextBoolean() ? '+' : '-';
        short operand1 = (short) random.nextInt(101);
        short operand2 = (short) random.nextInt(101);

        if (operator == '+') {
            return new AddEquation.AddEquationBuilder()
                    .setOperand1(operand1)
                    .setOperand2(operand2)
                    .build();
        } else {
            return new SubEquation.SubEquationBuilder()
                    .setOperand1(operand1)
                    .setOperand2(operand2)
                    .build();
        }
    }
}

// 算式集合类
class EquationCollection implements Iterable<IEqualtion> {
    private Set<IEqualtion> equations;

    // 构造函数
    public EquationCollection() {
        this.equations = new HashSet<>();
    }

    // 生成指定数量、满足约束条件的算式列表
    public void generate(int n, EquationChecker checker) {
        EquationGenerator generator = EquationGenerator.getInstance();

        while (equations.size() < n) {
            IEqualtion equation = generator.generateRandomEquation(new Random());
            if (checker.check(equation)) {
                equations.add(equation);
            }
        }
    }

    // 获取算式集合
    public Set<IEqualtion> getEquations() {
        return equations;
    }

    // 实现Iterable接口的iterator方法
    @Override
    public Iterator<IEqualtion> iterator() {
        return equations.iterator();
    }
}

// Printer 类
class Printer {
    // 打印算式列表
    public static void printEquations(List<IEqualtion> equations, int numberOfColumns) {
        int rowCount = (int) Math.ceil((double) equations.size() / numberOfColumns);
        int equationCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int index = i + j * rowCount;
                if (index < equations.size()) {
                    IEqualtion equation = equations.get(index);
                    // 打印算式
                    System.out.print(equationCount + 1 + ":\t" + equation.getOperand1() + " " +
                            equation.getOperator() + " " + equation.getOperand2() + " =\t");
                    equationCount++;
                }
            }
            System.out.println();
        }
    }

    // 打印算式及结果
    public static void printEquationsAndResults(List<IEqualtion> equations, int numberOfColumns) {
        int rowCount = (int) Math.ceil((double) equations.size() / numberOfColumns);
        int equationCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int index = i + j * rowCount;
                if (index < equations.size()) {
                    IEqualtion equation = equations.get(index);
                    // 打印算式及结果
                    System.out.print(equationCount + 1 + ":\t" + equation.getOperand1() + " " +
                            equation.getOperator() + " " + equation.getOperand2() + " = " +
                            equation.calculate() + "\t");
                    equationCount++;
                }
            }
            System.out.println();
        }
    }
}

// Exercise 类
class Exercise {
    private List<IEqualtion> equations;
    // 构造函数
    public Exercise() {
        this.equations = new ArrayList<>();
    }
    // 生成算式
    public void generateEquations(int numberOfEquations, EquationChecker checker) {
        EquationGenerator generator = EquationGenerator.getInstance();
        this.equations = generator.generate(numberOfEquations, checker);
    }
    // 获取算式列表
    public List<IEqualtion> getEquations() {
        return equations;
    }
    // 保存算式到文件
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            int equationCount = 1;

            for (IEqualtion equation : equations) {
                String equationString = equationCount + ":\t" + equation.getOperand1() + " " +
                        equation.getOperator() + " " + equation.getOperand2() + " = " +
                        equation.calculate() + "\n";

                writer.write(equationString);
                equationCount++;
            }
            System.out.println("保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件读取算式
    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("读取成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 主类
public class BinaryOperation4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EquationCollection equationCollection = new EquationCollection();
        int numberOfEquations = 0;
        int numberOfColumns = 0;

        while (true) {
            menu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("输入算式的数量（m）：");
                numberOfEquations = scanner.nextInt();
                System.out.print("输入每列的数量（n）：");
                numberOfColumns = scanner.nextInt();
                EquationChecker checker = new EquationCheckerOfRange(0, 100);
                equationCollection.generate(numberOfEquations, checker);
                Set<IEqualtion> equations = equationCollection.getEquations();
                Printer.printEquations(new ArrayList<>(equations), numberOfColumns);
            } else if (choice == 2) {
                Set<IEqualtion> equations = equationCollection.getEquations();
                List<IEqualtion> equationList = new ArrayList<>(equations);
                Printer.printEquationsAndResults(equationList, numberOfColumns);
            } else if (choice == 3) {
                System.out.println("保存算式到文件...");
                Exercise exercise = new Exercise();
                exercise.saveToFile("equations.txt");
                System.out.println("退出");
                break;
            } else if (choice == 4) {
                System.out.println("从文件读取算式...");
                Exercise exercise = new Exercise();
                exercise.readFromFile("equations.txt");
                Set<IEqualtion> equations = equationCollection.getEquations();
                List<IEqualtion> equationList = new ArrayList<>(equations);
                Printer.printEquations(equationList, numberOfColumns);
            }
        }
    }

    // 显示菜单
    public static void menu() {
        System.out.println("\n请作出选择:");
        System.out.println("1. 列出算数题");
        System.out.println("2. 列出结果");
        System.out.println("3. 保存算式到文件并退出");
        System.out.println("4. 从文件读取算式");
    }
}
