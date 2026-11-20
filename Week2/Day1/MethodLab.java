// Java Methods Lab - Week 2 Day 1
// One class, MethodLab, with a main method. Every method is public static.
public class MethodLab {

    public static void main(String[] args) {
        System.out.println("== Part 1: Data types ==");
        printProfile("Asha", 21, 5.6, true, 'A');
        printProfile("Ravi", 30, 5.9, false, 'B');
        System.out.println(average(1, 2, 2));
        System.out.println(fitsInByte(127));
        System.out.println(fitsInByte(128));
        System.out.println(fitsInByte(-129));

        System.out.println("== Part 2: Wrapper classes ==");
        System.out.println(addTexts("12", "30"));
        int r = boxTwice(21);
        System.out.println(r);
        describe(10);
        sameValue(127, 127);
        sameValue(1000, 1000);

        System.out.println("== Part 3: Casting ==");
        System.out.println(truncate(9.99));
        System.out.println(truncate(-9.99));
        System.out.println(widen(7));
        overflowDemo();
        System.out.println(shiftLetter('a', 2));

        System.out.println("== Part 4: Overloading ==");
        describeValue(5);
        describeValue(2.5);
        describeValue("hi");
        describeValue('A');
        describeValue(5L);

        System.out.println("== Part 5: Value vs reference types ==");
        int x = 1;
        tryChange(x);
        System.out.println("x = " + x);
        StringBuilder sb1 = new StringBuilder("Hi");
        appendBang(sb1);
        System.out.println(sb1);
        StringBuilder sb2 = new StringBuilder("Hi");
        replaceBuilder(sb2);
        System.out.println(sb2);
        String s = "java";
        shout(s);
        System.out.println(s);

        System.out.println("== Part 6: Reference variables ==");
        StringBuilder a = new StringBuilder("cat");
        StringBuilder b = a;
        b.append("s");
        System.out.println(a);
        compareRefs();
        System.out.println(safeLength(null));
        System.out.println(safeLength("hello"));

        System.out.println("== Part 7: String basics ==");
        System.out.println(initials("ashu", "jauhari"));
        System.out.println(clean(" HeLLo "));
        System.out.println(isPalindromeWord("Level"));
        System.out.println(isPalindromeWord("Java"));
        System.out.println(maskEmail("asha@mail.com"));

        System.out.println("== Part 8: StringBuilder and StringBuffer ==");
        System.out.println(buildCsv("a", "b", "c"));
        System.out.println(edit("Hello World"));
        timeJoin(false);
        timeJoin(true);
        System.out.println(safeAppend(new StringBuffer("Hi"), " there"));

        System.out.println("== Part 9: Capstone ==");
        System.out.println(formatReceipt("Asha", 3, 9.99));
        System.out.println(formatReceipt("Ravi", 2, 4.5));

        System.out.println("== Section B: Practice problems ==");
        System.out.println(toFahrenheit(0));
        System.out.println(toFahrenheit(37.5));
        System.out.println(toFahrenheit(-40));
        System.out.println(percent(45, 60));
        System.out.println(percent(1, 3));
        System.out.println(describeInt(255));
        System.out.println(describeInt(8));
        int px = 1, py = 2;
        swap(px, py);
        System.out.println("outside: x=" + px + " y=" + py);
        StringBuilder title = new StringBuilder("Rao");
        addTitle(title);
        System.out.println(title);
        String name = "Rao";
        addTitleToString(name); // result ignored on purpose
        System.out.println(name);
        System.out.println(addTitleToString(name));
        System.out.println(countChar("banana", 'a'));
        System.out.println(countChar("banana", 'z'));
        System.out.println(capitalize("jAVA"));
        System.out.println(padLeft("42", 5, '0'));
        System.out.println(padLeft("12345", 3, '0'));
        System.out.println(joinWithDash("ab", 3));
        System.out.println(joinWithDash("x", 1));
        System.out.println(roundHalfUp(2.5));
        System.out.println(roundHalfUp(2.4));
        System.out.println(roundHalfUp(7.0));
        System.out.println(factorialInt(5));
        System.out.println(factorialLong(5));
        System.out.println(factorialInt(13));
        System.out.println(factorialLong(13));
        System.out.println(factorialLong(20));
        System.out.println(summarize("Hello World"));
        System.out.println(summarize("Sky"));
    }

    // ---------- Part 1 ----------
    public static void printProfile(String name, int age, double height, boolean student, char grade) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student: " + student);
        System.out.println("Grade: " + grade);
    }

    public static double average(int a, int b, int c) {
        return (a + b + c) / 3.0; // 3.0 forces floating-point division
    }

    public static boolean fitsInByte(int value) {
        return value >= -128 && value <= 127; // byte range
    }

    // ---------- Part 2 ----------
    public static int addTexts(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public static Integer boxTwice(int x) {
        Integer boxed = x; // autoboxing
        return Integer.valueOf(boxed * 2);
    }

    public static void describe(Integer n) {
        System.out.println("Binary: " + Integer.toBinaryString(n));
        System.out.println("Max: " + Integer.MAX_VALUE);
        System.out.println("Compare with 10.5: " + Double.compare(n, 10.5));
    }

    public static boolean sameValue(Integer a, Integer b) {
        // Integer caches -128..127, so == compares the same object for 127
        // but two different objects for 1000. Use equals for wrapper values.
        System.out.println(a + ": equals=" + a.equals(b) + " ==" + (a == b));
        return a.equals(b);
    }

    // ---------- Part 3 ----------
    public static int truncate(double d) {
        return (int) d; // drops decimals, does not round
    }

    public static double widen(int i) {
        return i; // implicit widening int -> double
    }

    public static void overflowDemo() {
        int big = 130;
        byte b = (byte) big; // 130 - 256 = -126
        System.out.println(b);
    }

    public static char shiftLetter(char c, int by) {
        return (char) (c + by);
    }

    // ---------- Part 4 ----------
    public static void describeValue(int v) {
        System.out.println("int: " + v);
    }

    public static void describeValue(double v) {
        System.out.println("double: " + v);
    }

    public static void describeValue(String v) {
        System.out.println("String: " + v);
    }

    // ---------- Part 5 ----------
    public static void tryChange(int n) {
        n = 99; // only the local copy changes
    }

    public static void appendBang(StringBuilder sb) {
        sb.append("!"); // same object, so the caller sees it
    }

    public static void replaceBuilder(StringBuilder sb) {
        // The parameter holds a copy of the reference. Pointing it at a new
        // object does not move the caller's variable.
        sb = new StringBuilder("New");
    }

    public static void shout(String s) {
        // Strings are immutable; toUpperCase() returns a new String that is discarded.
        s = s.toUpperCase();
    }

    // ---------- Part 6 ----------
    public static void compareRefs() {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        System.out.println(s1 == s2);      // true: both literals share one pooled object
        System.out.println(s1 == s3);      // false: new String creates a separate object
        System.out.println(s1.equals(s3)); // true: same characters
    }

    public static int safeLength(String s) {
        if (s == null) {
            return -1;
        }
        return s.length();
    }

    // ---------- Part 7 ----------
    public static String initials(String first, String last) {
        return ("" + first.charAt(0) + last.charAt(0)).toUpperCase();
    }

    public static String clean(String raw) {
        return raw.trim().toLowerCase();
    }

    public static boolean isPalindromeWord(String w) {
        String reversed = new StringBuilder(w).reverse().toString();
        return w.equalsIgnoreCase(reversed);
    }

    public static String maskEmail(String email) {
        int at = email.indexOf('@');
        String domain = email.substring(at);
        return email.substring(0, 1) + "*".repeat(at - 1) + domain;
    }

    // ---------- Part 8 ----------
    public static String buildCsv(String a, String b, String c) {
        return new StringBuilder().append(a).append(",").append(b).append(",").append(c).toString();
    }

    public static String edit(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(0, "[");                 // [Hello World
        sb.append("]");                    // [Hello World]
        sb.replace(7, 12, "Java");         // [Hello Java]
        sb.deleteCharAt(6);                // [HelloJava]
        return sb.toString();
    }

    public static long timeJoin(boolean useBuilder) {
        int times = 20000;
        long start = System.nanoTime();
        if (useBuilder) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < times; i++) {
                sb.append("x");
            }
        } else {
            String s = "";
            for (int i = 0; i < times; i++) {
                s += "x";
            }
        }
        long elapsed = System.nanoTime() - start;
        System.out.println((useBuilder ? "StringBuilder : " : "String += : ") + elapsed + " ns");
        return elapsed;
    }

    public static String safeAppend(StringBuffer sb, String part) {
        // StringBuffer methods are synchronized, so it is safe when several threads share it.
        sb.append(part);
        return sb.toString();
    }

    // ---------- Part 9 ----------
    public static String formatReceipt(String customer, int quantity, double unitPrice) {
        double total = quantity * unitPrice;
        int whole = (int) total;
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.toUpperCase()).append("\n");
        sb.append("Qty: ").append(quantity).append(" | Price: ").append(unitPrice).append("\n");
        sb.append("Total: ").append(total).append(" (whole: ").append(whole).append(")");
        return sb.toString();
    }

    // ---------- Section B ----------
    public static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static int percent(int obtained, int total) {
        double value = (double) obtained / total * 100; // decimals first
        return (int) value;                              // cut off, not rounded
    }

    public static String describeInt(int n) {
        return n + " -> binary " + Integer.toBinaryString(n)
                + ", hex " + Integer.toHexString(n)
                + ", octal " + Integer.toOctalString(n);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("inside: a=" + a + " b=" + b);
        // Why did x and y not change? Primitives are passed by value: swap works
        // on copies of x and y, so the originals in main are untouched.
    }

    public static void addTitle(StringBuilder name) {
        name.insert(0, "Dr. "); // mutates the object the caller also holds
    }

    public static String addTitleToString(String name) {
        // Why did the builder change but the String did not? A StringBuilder is
        // mutable, so the caller sees the change. A String is immutable, so
        // "Dr. " + name builds a new String that must be returned and stored.
        return "Dr. " + name;
    }

    public static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static String padLeft(String s, int width, char fill) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < width; i++) {
            sb.append(fill);
        }
        return sb.append(s).toString();
    }

    public static String joinWithDash(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(s);
        }
        return sb.toString();
    }

    public static int roundHalfUp(double d) {
        return (int) (d + 0.5); // non-negative numbers only
    }

    public static int factorialInt(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    // Why is the int result for 13 wrong? 13! = 6227020800, which is larger than
    // Integer.MAX_VALUE (2147483647), so the int multiplication overflows and wraps.

    public static int countVowels(String s) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                count++;
            }
        }
        return count;
    }

    public static String summarize(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append("Length: ").append(text.length());
        sb.append(" | Upper: ").append(text.toUpperCase());
        sb.append(" | Vowels: ").append(countVowels(text));
        return sb.toString();
    }
}
