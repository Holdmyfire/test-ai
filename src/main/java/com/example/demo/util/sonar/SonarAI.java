package com.example.demo.util.sonar;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SonarAI
 * @author: fang.xu
 * @date: 2025/3/16 8:37
 * @Copyright: 2018 www.dbappsecurity.com.cn. All rights reserved.
 * @Description:
 */
public class SonarAI {
    // 魔法数字，未使用的常量
    private static final int MAGIC_NUMBER_1 = 42;
    private static final String MAGIC_STRING = "This is a magic string";

    // 未使用的字段
    private int unusedField;

    public SonarAI() {

    }

    // 缺少注释的构造函数
    public void bad_class_name() {
        // 未使用的局部变量
        int unusedLocalVariable = 10;
    }

    // 过长的方法，超过 80 行
    public void longMethod() {
        // 魔法数字
        int limit = 10;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
        // 重复代码
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
        // 嵌套过深的循环
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                for (int k = 0; k < limit; k++) {
                    // 空代码块
                    if (i + j + k > 20) {
                        // 什么都不做
                    }
                }
            }
        }
        // 未使用的变量
        int anotherUnusedVariable = 20;
        // 复杂的条件判断
        if (list.size() > 5 && list.get(0) == 0 && list.get(list.size() - 1) == limit - 1) {
            // 代码逻辑
        }
        // 重复代码
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
        // 未使用的返回值
        list.toString();
    }

    // 命名不规范的方法
    public void bad_method_name() {
        // 未使用的参数
        methodWithUnusedParameter(10, 20);
    }

    public void methodWithUnusedParameter(int a, int b) {
        // 只使用了一个参数
        System.out.println(a);
    }

    // 缺少注释的方法
    public int calculate(int a, int b) {
        // 魔法数字
        return a + b + 5;
    }

    // 未使用的方法
    private void unusedMethod() {
        System.out.println("This method is unused.");
    }

    // 违反单一职责原则的类
    public void multipleResponsibilities() {
        // 处理业务逻辑
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        // 同时进行输出操作
        System.out.println("The sum is: " + sum);
    }

    // 过长的参数列表
    public void longParameterList(int a, int b, int c, int d, int e, int f, int g, int h) {
        System.out.println(a + b + c + d + e + f + g + h);
    }

    // 硬编码的字符串
    public void hardCodedString() {
        String url = "http://example.com";
        System.out.println(url);
    }

    // 未使用的导入  import java.util.Date;


    // 未使用的泛型参数
    public class UnusedGeneric<T> {
        public void doSomething() {
            System.out.println("Doing something.");
        }
    }

    // 静态方法调用非静态方法
    public static void staticCallNonStatic() {
        SonarAI obj = new SonarAI();
        obj.longMethod();
    }

    // 低内聚的类
    public class LowCohesion {
        public void printMessage() {
            System.out.println("This is a message.");
        }

        public int calculateSum(int a, int b) {
            return a + b;
        }
    }

    // 未使用的类
    public class UnusedClass {
        public void doNothing() {
            // 什么都不做
        }
    }

    // 注释与代码不匹配
    /**
     * This method is supposed to calculate the product of two numbers.
     */
    public int wrongCommentMethod(int a, int b) {
        return a + b;
    }

    // 重复的字符串常量
    public void repeatedStringConstants() {
        String message1 = "Hello";
        String message2 = "Hello";
        System.out.println(message1 + " " + message2);
    }

    // 未使用的静态导入
    // import static java.lang.Math.PI;

    // 未使用的接口
    public interface UnusedInterface {
        void doSomething();
    }

    // 嵌套类未使用
    public class Outer {
        public class Inner {
            public void doInnerThing() {
                System.out.println("Doing inner thing.");
            }
        }
    }

    // 未使用的枚举
    public enum UnusedEnum {
        VALUE1, VALUE2
    }

    // 异常抛出后未处理
    public void throwException() throws Exception {
        throw new Exception("This is an exception.");
    }

    // 空的静态初始化块
    static {
        // 什么都不做
    }

    // 方法参数类型可简化
    public void parameterTypeCanBeSimplified(List<Integer> list) {
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    // 未使用的资源

    // 数组初始化可简化
    public void arrayInitialization() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
    }

    // 未使用的类型参数
    public class UnusedTypeParameter<T> {
        public void doWork() {
            System.out.println("Working.");
        }
    }

    // 字符串拼接使用 + 而不是 StringBuilder
    public void stringConcatenation() {
        String result = "";
        for (int i = 0; i < 10; i++) {
            result = result + i;
        }
        System.out.println(result);
    }

    // 未使用的局部类
    public void localClass() {
        class Local {
            public void doLocal() {
                System.out.println("Doing local.");
            }
        }
        // 未使用 Local 类
    }

    // 未使用的注解
    @Deprecated
    public void deprecatedMethod() {
        System.out.println("This method is deprecated.");
    }

    // 类成员访问控制不当
    public int publicField = 10;

    // 代码逻辑过于复杂
    public boolean complexLogic(int a, int b, int c) {
        return (a > 10 && b < 20 && c != 0) || (a < 5 && b > 30 && c == 1);
    }

    // 未使用的布尔变量
    public void unusedBoolean() {
        boolean unused = true;
    }

    // 未使用的集合
    public void unusedCollection() {
        List<String> list = new ArrayList<>();
        // 未使用 list
    }

    // 未使用的对象创建
    public void unusedObjectCreation() {
        Object obj = new Object();
        // 未使用 obj
    }

    // 未使用的异常变量
    public void unusedExceptionVariable() {
        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            // 未使用 e
        }
    }

    // 未使用的泛型类实例
    public void unusedGenericInstance() {
        UnusedGeneric<Integer> generic = new UnusedGeneric<>();
        // 未使用 generic
    }

    // 未使用的内部类实例
    public void unusedInnerClassInstance() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        // 未使用 inner
    }

    // 未使用的枚举实例
    public void unusedEnumInstance() {
        UnusedEnum enumValue = UnusedEnum.VALUE1;
        // 未使用 enumValue
    }

    // 未使用的接口实现
    public class ImplementUnusedInterface implements UnusedInterface {
        @Override
        public void doSomething() {
            System.out.println("Implementing unused interface.");
        }
    }

    public void unusedInterfaceImplementation() {
        ImplementUnusedInterface impl = new ImplementUnusedInterface();
        // 未使用 impl
    }

    // 未使用的静态字段
    public static int unusedStaticField = 10;

    // 未使用的包级私有类
    class PackagePrivateClass {
        public void doPackagePrivate() {
            System.out.println("Doing package private.");
        }
    }

    public void unusedPackagePrivateClass() {
        PackagePrivateClass ppc = new PackagePrivateClass();
        // 未使用 ppc
    }

    // 未使用的受保护字段
    protected int unusedProtectedField = 20;

    // 未使用的默认构造函数
    public SonarAI(int a) {
        // 构造函数逻辑
    }

    // 未使用的返回类型
    public String unusedReturnType() {
        return null;
    }

    // 未使用的类型参数化类型
    public class TypeParameterizedType<T> {
        public void doTypeParam() {
            System.out.println("Doing type param.");
        }
    }

    public void unusedTypeParameterizedType() {
        TypeParameterizedType<String> tpt = new TypeParameterizedType<>();
        // 未使用 tpt
    }

    // 未使用的静态导入成员
    // import static java.lang.Math.abs;

    // 未使用的模块声明
    void module(){
        // 模块声明逻辑
    }

    // 未使用的版本注解
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    @java.lang.annotation.Target(java.lang.annotation.ElementType.TYPE)
    public @interface Version {
        String value();
    }

    @Version("1.0")
    public class VersionedClass {
        public void doVersioned() {
            System.out.println("Doing versioned.");
        }
    }

    public void unusedVersionedClass() {
        VersionedClass vc = new VersionedClass();
        // 未使用 vc
    }

    // 未使用的 Lambda 表达式
    public void unusedLambda() {
        java.util.function.Consumer<Integer> consumer = (i) -> System.out.println(i);
        // 未使用 consumer
    }

    // 未使用的 Stream 操作
    public void unusedStream() {
        java.util.stream.Stream.of(1, 2, 3).filter(i -> i > 1);
        // 未对 Stream 进行终端操作
    }

    // 未使用的 Optional 实例
    public void unusedOptional() {
        java.util.Optional<Integer> optional = java.util.Optional.of(10);
        // 未使用 optional
    }

    // 未使用的 Supplier 实例
    public void unusedSupplier() {
        java.util.Optional<Integer> optional = java.util.Optional.of(1000);
        // 未使用 supplier
    }

    // 未使用的 Function 实例
    public void unusedFunction() {
        // 未使用 function
    }

    // 未使用的 Predicate 实例
    public void unusedPredicate() {
        // 未使用 predicate
    }

    // 未使用的 BiFunction 实例
    public void unusedBiFunction() {
        // 未使用 biFunction
    }

    // 未使用的 BiConsumer 实例
    public void unusedBiConsumer() {
        java.util.function.BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);
        // 未使用 biConsumer
    }

    // 未使用的 Comparator 实例
    public void unusedComparator() {
        // 未使用 comparator
    }

    // 未使用的 Collector 实例
    public void unusedCollector() {
        // 未使用 collector
    }

    // 未使用的 Stream.Builder 实例
    public void unusedStreamBuilder() {
        java.util.stream.Stream.Builder<Integer> builder = java.util.stream.Stream.builder();
        // 未使用 builder
    }

    // 未使用的 IntStream 实例
    public void unusedIntStream() {
        java.util.stream.IntStream intStream = java.util.stream.IntStream.range(0, 10);
        // 未使用 intStream
    }

    // 未使用的 LongStream 实例
    public void unusedLongStream() {
        java.util.stream.LongStream longStream = java.util.stream.LongStream.range(0, 10L);
        // 未使用 longStream
    }

    // 未使用的 DoubleStream 实例
    public void unusedDoubleStream() {
        java.util.stream.DoubleStream doubleStream = java.util.stream.DoubleStream.of(1.0, 2.0, 3.0);
        // 未使用 doubleStream
    }

    // 未使用的 AtomicInteger 实例
    public void unusedAtomicInteger() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(10);
        // 未使用 atomicInteger
    }

    // 未使用的 AtomicLong 实例
    public void unusedAtomicLong() {
        java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(10L);
        // 未使用 atomicLong
    }

    // 未使用的 AtomicBoolean 实例
    public void unusedAtomicBoolean() {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);
        // 未使用 atomicBoolean
    }

    // 未使用的 Semaphore 实例
    public void unusedSemaphore() {
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(1);
        // 未使用 semaphore
    }

    // 未使用的 CountDownLatch 实例
    public void unusedCountDownLatch() {
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        // 未使用 latch
    }

    // 未使用的 CyclicBarrier 实例
    public void unusedCyclicBarrier() {
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(1);
        // 未使用 barrier
    }

    // 未使用的 ExecutorService 实例
    public void unusedExecutorService() {
        java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newSingleThreadExecutor();
        // 未使用 executorService
    }

    // 未使用的 Future 实例
    public void unusedFuture() {
        java.util.concurrent.Future<Integer> future = null;
        // 未使用 future
    }

    // 未使用的 CompletableFuture 实例
    public void unusedCompletableFuture() {
        java.util.concurrent.CompletableFuture<Integer> completableFuture = java.util.concurrent.CompletableFuture.completedFuture(10);
        // 未使用 completableFuture
    }

    // 未使用的 ForkJoinPool 实例
    public void unusedForkJoinPool() {
        java.util.concurrent.ForkJoinPool forkJoinPool = new java.util.concurrent.ForkJoinPool();
        // 未使用 forkJoinPool
    }

    // 未使用的 TransferQueue 实例
    public void unusedTransferQueue() {
        java.util.concurrent.TransferQueue<Integer> transferQueue = new java.util.concurrent.LinkedTransferQueue<>();
        // 未使用 transferQueue
    }

    // 未使用的 BlockingQueue 实例
    public void unusedBlockingQueue() {
        java.util.concurrent.BlockingQueue<Integer> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<>(10);
        // 未使用 blockingQueue
    }

    // 未使用的 ConcurrentMap 实例
    public void unusedConcurrentMap() {
        java.util.concurrent.ConcurrentMap<Integer, String> concurrentMap = new java.util.concurrent.ConcurrentHashMap<>();
        // 未使用 concurrentMap
    }

    // 未使用的 CopyOnWriteArrayList 实例
    public void unusedCopyOnWriteArrayList() {
        java.util.concurrent.CopyOnWriteArrayList<Integer> list = new java.util.concurrent.CopyOnWriteArrayList<>();
        // 未使用 list
    }

    // 未使用的 ThreadLocalRandom 实例
    public void unusedThreadLocalRandom() {
        java.util.concurrent.ThreadLocalRandom random = java.util.concurrent.ThreadLocalRandom.current();
        // 未使用 random
    }

    // 未使用的 TimeUnit 实例
    public void unusedTimeUnit() {
        java.util.concurrent.TimeUnit unit = java.util.concurrent.TimeUnit.SECONDS;
        // 未使用 unit
    }

    // 未使用的 UUID 实例
    public void unusedUUID() {
        java.util.UUID uuid = java.util.UUID.randomUUID();
        // 未使用 uuid
    }

    // 未使用的 Path 实例
    public void unusedPath() {
        java.nio.file.Path path = java.nio.file.Paths.get("file.txt");
        // 未使用 path
    }

    // 未使用的 Files 实例
    public void unusedFiles() {
        java.nio.file.Files.exists(null);
        // 未使用结果
    }

    // 未使用的 PrintWriter 实例
    public void unusedPrintWriter() {
        java.io.PrintWriter writer = null;
        try {
            writer = new java.io.PrintWriter("file.txt");
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
        // 未使用 writer
    }

    // 未使用的 ObjectInputStream 实例
    public void unusedObjectInputStream() {
        java.io.ObjectInputStream ois = null;
        try {
            ois = new java.io.ObjectInputStream(new java.io.FileInputStream("file.txt"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 未使用 ois
    }

    // 未使用的 ObjectOutputStream 实例
    public void unusedObjectOutputStream() {
        java.io.ObjectOutputStream oos = null;
        try {
            oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("file.txt"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 未使用 oos
    }

    // 未使用的 URL 实例
    public void unusedURL() {
        java.net.URL url = null;
        try {
            url = new java.net.URL("http://example.com");
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }
        // 未使用 url
    }

    // 未使用的 HttpURLConnection 实例
    public void unusedHttpURLConnection() {
        java.net.HttpURLConnection connection = null;
        try {
            java.net.URL url = new java.net.URL("http://example.com");
            connection = (java.net.HttpURLConnection) url.openConnection();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 未使用 connection
    }

    // 未使用的 Socket 实例
    public void unusedSocket() {
        java.net.Socket socket = null;
        try {
            socket = new java.net.Socket("localhost", 8080);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 未使用 socket
    }

    // 未使用的 ServerSocket 实例
    public void unusedServerSocket() {
        java.net.ServerSocket serverSocket = null;
        try {
            serverSocket = new java.net.ServerSocket(8080);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 未使用 serverSocket
    }

    // 未使用的 DatagramSocket 实例
    public void unusedDatagramSocket() {
        java.net.DatagramSocket socket = null;
        try {
            socket = new java.net.DatagramSocket();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        // 未使用 socket
    }

    // 未使用的 InetAddress 实例
    public void unusedInetAddress() {
        java.net.InetAddress address = null;
        try {
            address = java.net.InetAddress.getByName("localhost");
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
        }
        // 未使用 address
    }

    // 未使用的 LocalDate 实例
    public void unusedLocalDate() {
        java.time.LocalDate date = java.time.LocalDate.now();
        // 未使用 date
    }

    // 未使用的 LocalTime 实例
    public void unusedLocalTime() {
        java.time.LocalTime time = java.time.LocalTime.now();
        // 未使用 time
    }

    // 未使用的 LocalDateTime 实例
    public void unusedLocalDateTime() {
        java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
        // 未使用 dateTime
    }

    // 未使用的 ZonedDateTime 实例
    public void unusedZonedDateTime() {
        java.time.ZonedDateTime zonedDateTime = java.time.ZonedDateTime.now();
        // 未使用 zonedDateTime
    }

    // 未使用的 DateTimeFormatter 实例
    public void unusedDateTimeFormatter() {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ISO_DATE;
        // 未使用 formatter
    }

    // 未使用的 Duration 实例
    public void unusedDuration() {
        java.time.Duration duration = java.time.Duration.ofSeconds(10);
        // 未使用 duration
    }

    // 未使用的 Period 实例
    public void unusedPeriod() {
        java.time.Period period = java.time.Period.ofDays(10);
        // 未使用 period
    }

    // 未使用的 ChronoUnit 实例
    public void unusedChronoUnit() {
        java.time.temporal.ChronoUnit unit = java.time.temporal.ChronoUnit.DAYS;
        // 未使用 unit
    }

    // 未使用的 ZoneId 实例
    public void unusedZoneId() {
        java.time.ZoneId zoneId = java.time.ZoneId.of("UTC");
        // 未使用 zoneId
    }

    // 未使用的 Currency 实例
    public void unusedCurrency() {
        java.util.Currency currency = java.util.Currency.getInstance("USD");
        // 未使用 currency
    }

    // 未使用的 Locale 实例
    public void unusedLocale() {
        java.util.Locale locale = java.util.Locale.US;
        // 未使用 locale
    }

    // 未使用的 ResourceBundle 实例
    public void unusedResourceBundle() {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("messages");
        // 未使用 bundle
    }

    // 未使用的 PropertyResourceBundle 实例
    public void unusedPropertyResourceBundle() {
        java.util.PropertyResourceBundle bundle = null;
        try {
            bundle = new java.util.PropertyResourceBundle(new java.io.FileInputStream("messages.properties"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}