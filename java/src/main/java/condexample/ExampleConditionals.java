package condexample;

public class ExampleConditionals {

    static int invert_negative(int x) {
        if (x != 3) {
            return 3;
        } else {
            return 4;
        }
    }

    static int invert_positive(int x) {
        if (x == 3) {
            return 4;
        } else {
            return 3;
        }
    }

    static int redundant_else(int x) {
        if (x < 3) {
            return 1;
        } else if (x < 10) {
            return 10;
        }
        if (x < 30) {
            return 30;
        }
        return 0;
    }

    static int missing_else(int x) {
        if (x < 3) {
            return 1;
        }
        if (x < 10) {
            return 10;
        }
        if (x < 30) {
            return 30;
        }
        return 0;
    }

    static boolean deMorganAnd(int x) {
        return !(x != 5 && x != 7);
    }
    static boolean deMorganOr(int x) {
        return x == 5 || x == 7;
    }

    static int join_AND(int x, int y) {
        if (x == 3) {
            if (y == 4) {
                return x + y;
            }
        }
        return 0;
    }

    static int split_AND(int x, int y) {
        if (x == 3 && y == 4) {
            return x + y;
        } else {
            return 0;
        }
    }

    static boolean join_OR(int x, int y) {
        if (x >= 0) {
            return true;
        }
        if (y <= 3) {
            return true;
        }
        return y == 10;
    }

    static boolean split_OR(int x, int y) {
        if (x >= 0 || y <= 3 || y == 10) {
            return true;
        }
        return false;
    }

    static int join_statements(int x, int y) {
        int result = 0;
        int factor = 1;
        if (x > 3) {
            factor = x;
        }
        if (x > 3) {
            result += y * 3;
        }
        return result * factor;
    }

    static int split_statements(int x, int y) {
        int result = 0;
        int factor = 1;
        if (x > 3) {
            result += y * 3;
            factor = x;
        }
        return result * factor;
    }


    public static int y;
    public static int z;

    static void introduce_guard_clause_simple(int x) {
        if (x == 3) {
            ExampleConditionals.y = 4;
            // imagine lots more lines of code here including if statements
            ExampleConditionals.z = x;
        }
    }

    static void remove_guard_clause_simple(int x) {
        if (x != 3) {
            return;
        }
        ExampleConditionals.y = 4;
        // imagine lots more lines of code here including if statements
        ExampleConditionals.z = x;
    }

    static int introduce_guard_clause_single_return(int x) {
        int result = 0;
        if (x != 3) {
            ExampleConditionals.y = 4;
            // imagine lots more lines of code here including if statements
            ExampleConditionals.z = x;
            result = 4*x + y;
        }
        return result;
    }

    static int remove_guard_clause_single_return(int x) {
        if (x == 3) {
            return 0;
        }

        ExampleConditionals.y = 4;
        // imagine lots more lines of code here including if statements
        ExampleConditionals.z = x;
        return 4*x + y;
    }

    static int introduce_guard_clause_multi_return(int x) {
        if (x != 3) {
            ExampleConditionals.y = 4;
            // imagine lots more lines of code here including if statements
            ExampleConditionals.z = x;
            return 4 * x + y;
        } else {
            return 0;
        }
    }

    static int remove_guard_clause_multi_return(int x) {
        if (x == 3) {
            return 0;
        }
        ExampleConditionals.y = 4;
        // imagine lots more lines of code here including if statements
        ExampleConditionals.z = x;

        return 4 * x + y;
    }

    public static String liftUpSimple(boolean a, boolean b) {
        if (a) {
            if (b) {
                return aTrueBTrue();
            } else {
                return aTrueBFalse();
            }
        } else {
            if (b) {
                return aFalseBTrue();
            } else {
                return aFalseBFalse();
            }
        }
    }

    public static String aFalseBFalse() {
        return "AFalseBFalse";
    }

    public static String aFalseBTrue() {
        return "AFalseBTrue";
    }

    public static String aTrueBFalse() {
        return "ATrueBFalse";
    }

    public static String aTrueBTrue() {
        return "ATrueBTrue";
    }


    static int normalize(String s1, String s2) {
        if (!s1.equals("hello")) {
            if (!s2.equals("world")) {
                if (!s1.equals("foo")) {
                    return 6;
                }
                return 1;
            } else if (!s1.equals("foo")) {
                return 2;
            }
        } else {
            if (s2.equals("bar")) {
                return 3;
            } else if (!s2.equals("world")) {
                return 4;
            }
            return 5;
        }
        return 0;
    }

}
