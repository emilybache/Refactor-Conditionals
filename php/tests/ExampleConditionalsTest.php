<?php

declare(strict_types=1);

namespace Sample\Tests;

use PHPUnit\Framework\TestCase;
use Sample\ExampleConditionals;

class ExampleConditionalsTest extends TestCase {

    /**
     * @dataProvider invertProvider
     */
    public function testInvert($expected, $actual) {
        $this->assertEquals($expected, ExampleConditionals::invert($actual));
    }

    public function invertProvider() {
        return [
            [4, 3],
            [3, 5],
            [3, 1],
            [3, 4]
        ];
    }

    /**
     * @dataProvider joinStatementsProvider
     */
    public function testJoinStatements($x, $expected) {
        $this->assertEquals($expected, ExampleConditionals::redundantElse($x));
    }

    public function joinStatementsProvider() {
        return [
            [2, 1],
            [7, 10],
            [29, 30],
            [30, 0]
        ];
    }

    /**
     * @dataProvider deMorganTrueProvider
     */
    public function testDeMorganTrue($valid) {
        $this->assertTrue(ExampleConditionals::deMorgan($valid));
    }

    public function deMorganTrueProvider() {
        return [
            [5],
            [7]
        ];
    }

    /**
     * @dataProvider deMorganFalseProvider
     */
    public function testDeMorganFalse($invalid) {
        $this->assertFalse(ExampleConditionals::deMorgan($invalid));
    }

    public function deMorganFalseProvider() {
        return [
            [4],
            [8]
        ];
    }

    /**
     * @dataProvider joinAndProvider
     */
    public function testJoinAnd($x, $y, $expected) {
        $this->assertEquals($expected, ExampleConditionals::joinAnd($x, $y));
    }

    public function joinAndProvider() {
        return [
            [4, 3, 0],
            [7, 3, 0],
            [1, 3, 0],
            [3, 4, 7],
            [3, 11, 0]
        ];
    }

    /**
     * @dataProvider splitAndProvider
     */
    public function testSplitAnd($x, $y, $expected) {
        $this->assertEquals($expected, ExampleConditionals::splitAnd($x, $y));
    }

    public function splitAndProvider() {
        return [
            [4, 3, 0],
            [7, 3, 0],
            [1, 3, 0],
            [3, 4, 7],
            [3, 11, 0]
        ];
    }

    /**
     * @dataProvider joinOrProvider
     */
    public function testJoinOr($x, $y, $expected) {
        $this->assertEquals($expected, ExampleConditionals::joinOr($x, $y));
    }

    public function joinOrProvider() {
        return [
            [0, 3, true],
            [3, 6, true],
            [-1, 3, true],
            [-1, 5, false],
            [-1, 10, true]
        ];
    }

    /**
     * @dataProvider splitOrProvider
     */
    public function testSplitOr($x, $y, $expected) {
        $this->assertEquals($expected, ExampleConditionals::splitOr($x, $y));
    }

    public function splitOrProvider() {
        return [
            [0, 3, true],
            [3, 6, true],
            [-1, 3, true],
            [-1, 5, false],
            [-1, 10, true]
        ];
    }

    /**
     * @dataProvider splitStatementsProvider
     */
    public function testSplitStatements($x, $y, $expected) {
        $this->assertEquals($expected, ExampleConditionals::splitStatements($x, $y));
    }

    public function splitStatementsProvider() {
        return [
            [4, 3, 36],
            [7, 3, 63],
            [1, 3, 0],
            [3, 4, 0]
        ];
    }

    /**
     * @dataProvider joinStatementsXYProvider
     */
    public function testJoinStatementsXY($x, $y, $expected) {
        $this->assertEquals($expected, ExampleConditionals::joinStatements($x, $y));
    }

    public function joinStatementsXYProvider() {
        return [
            [4, 3, 36],
            [7, 3, 63],
            [1, 3, 0],
            [3, 4, 0]
        ];
    }

    public function test_A_True_B_True() {
        $this->assertEquals("ATrueBTrue", ExampleConditionals::lift_up_simple(true, true));
    }

    public function test_A_True_B_False() {
        $this->assertEquals("ATrueBFalse", ExampleConditionals::lift_up_simple(true, false));
    }

    public function test_A_False_B_True() {
        $this->assertEquals("AFalseBTrue", ExampleConditionals::lift_up_simple(false, true));
    }

    public function test_A_False_B_False() {
        $this->assertEquals("AFalseBFalse", ExampleConditionals::lift_up_simple(false, false));
    }

    /**
     * @dataProvider liftUpHelloProvider
     */
    public function testLiftUpSimple($s1, $s2, $expected) {
        $this->assertEquals($expected, ExampleConditionals::lift_up_hello($s1, $s2));
    }

    public function liftUpHelloProvider() {
        return [
            ["foo", "world", 0],
            ["foo", "bar", 1],
            ["bar", "world", 2],
            ["hello", "bar", 3],
            ["hello", "foo", 4],
            ["hello", "world", 5],
            ["bar", "foo", 6]
        ];
    }

}

?>

