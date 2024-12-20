<?php

declare(strict_types=1);

namespace Sample;

class ExampleConditionals {

    public static function deMorgan($x): bool
    {
        return !($x != 5 && $x != 7);
        // (x == 5 || x == 7) is the same as (x != 5 && x != 7)
    }

    public static function splitAnd($x, $y)
    {
        if ($x == 3 && $y == 4) {
            return $x + $y;
        } else {
            return 0;
        }
    }

    public static function joinAnd($x, $y)
    {
        if ($x == 3) {
            if ($y == 4) {
                return $x + $y;
            }
        }
        return 0;
    }

    public static function joinOr($x, $y): bool
    {
        if ($x >= 0) {
            return true;
        }
        if ($y <= 3) {
            return true;
        }
        return $y == 10;
    }

    public static function splitOr($x, $y): bool
    {
        if ($x >= 0 || $y <= 3 || $y == 10) {
            return true;
        }
        return false;
    }

    public static function splitStatements($x, $y): float|int
    {
        $result = 0;
        $factor = 1;
        if ($x > 3) {
            $result += $y * 3;
            $factor = $x;
        }
        return $result * $factor;
    }

    public static function joinStatements($x, $y): float|int
    {
        $result = 0;
        $factor = 1;
        if ($x > 3) {
            $factor = $x;
        }
        if ($x > 3) {
            $result += $y * 3;
        }
        return $result * $factor;
    }

    public static function invert($x): int
    {
        if ($x != 3) {
            return 3;
        } else {
            return 4;
        }
    }

    public static function redundantElse($x): int
    {
        if ($x < 3) {
            return 1;
        } else if ($x < 10) {
            return 10;
        }
        if ($x < 30) {
            return 30;
        }
        return 0;
    }


    public static function lift_up_simple($a, $b): string
    {
        if ($a) {
            if ($b) {
                return self::a_true_b_true();
            } else {
                return self::a_true_b_false();
            }
        } else {
            if ($b) {
                return self::a_false_b_true();
            } else {
                return self::a_false_b_false();
            }
        }
    }

    static function a_false_b_false(): string
    {
        return "AFalseBFalse";
    }

    static function a_false_b_true(): string
    {
        return "AFalseBTrue";
    }

    static function a_true_b_false(): string
    {
        return "ATrueBFalse";
    }

    static function a_true_b_true(): string
    {
        return "ATrueBTrue";
    }

    public static function lift_up_hello($s1, $s2): int
    {
        if ($s1 !== "hello") {
            if ($s2 !== "world") {
                if ($s1 !== "foo") {
                    return 6;
                }
                return 1;
            } else if ($s1 !== "foo") {
                return 2;
            }
        } else {
            if ($s2 === "bar") {
                return 3;
            } else if ($s2 !== "world") {
                return 4;
            }
            return 5;
        }
        return 0;
    }

}

?>
