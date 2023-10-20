using System.Runtime.InteropServices;

namespace RefactorConditionals.Tests;

public class ExampleConditionalsTest
{

    [Theory]
    [InlineData(4, 3)]
    [InlineData(3, 5)]
    [InlineData(3, 1)]
    [InlineData(3, 4)]
	void Invert(int expected, int actual)
    {
        Assert.Equal(expected, ExampleConditionals.Invert(actual));
    }

    [Theory]
    [InlineData(2, 1)]
    [InlineData(7, 10)]
    [InlineData(29, 30)]
    [InlineData(30, 0)]
	void Redundant_else(int x, int expected)
    {
        Assert.Equal(expected, ExampleConditionals.Redundant_else(x));
    }

    [Theory]
    [InlineData(5)]
    [InlineData(7)]
	void DeMorgan_true(int valid)
    {
        Assert.True(ExampleConditionals.DeMorgan(valid));
    }

    [Theory]
    [InlineData(4)]
    [InlineData(8)]
	void DeMorgan_false(int invalid)
    {
        Assert.False(ExampleConditionals.DeMorgan(invalid));
    }

    [Theory]
    [InlineData(4, 3, 0)]
    [InlineData(7, 3, 0)]
    [InlineData(1, 3, 0)]
    [InlineData(3, 4, 7)]
    [InlineData(3, 11, 0)]
	void Join_AND(int x, int y, int expected)
    {
        Assert.Equal(expected, ExampleConditionals.Join_AND(x, y));
    }

    [Theory]
    [InlineData(4, 3, 0)]
    [InlineData(7, 3, 0)]
    [InlineData(1, 3, 0)]
    [InlineData(3, 4, 7)]
    [InlineData(3, 11, 0)]
	void Split_AND(int x, int y, int expected)
    {
        Assert.Equal(expected, ExampleConditionals.Split_AND(x, y));
    }

    [Theory]
    [InlineData(0, 3, true)]
    [InlineData(3, 6, true)]
    [InlineData(-1, 3, true)]
    [InlineData(-1, 5, false)]
    [InlineData(-1, 10, true)]
	void Join_OR(int x, int y, bool expected)
    {
        Assert.Equal(expected, ExampleConditionals.Join_OR(x, y));
    }

    [Theory]
    [InlineData(0, 3, true)]
    [InlineData(3, 6, true)]
    [InlineData(-1, 3, true)]
    [InlineData(-1, 5, false)]
    [InlineData(-1, 10, true)]
	void Split_OR(int x, int y, bool expected)
    {
        Assert.Equal(expected, ExampleConditionals.Split_OR(x, y));
    }

    [Theory]
    [InlineData(4, 3, 36)]
    [InlineData(7, 3, 63)]
    [InlineData(1, 3, 0)]
    [InlineData(3, 4, 0)]
	void Split_statements(int x, int y, int expected)
    {
        Assert.Equal(expected, ExampleConditionals.Split_statements(x, y));
    }

    [Theory]
    [InlineData(4, 3, 36)]
    [InlineData(7, 3, 63)]
    [InlineData(1, 3, 0)]
    [InlineData(3, 4, 0)]
	void Join_statements(int x, int y, int expected)
    {
        Assert.Equal(expected, ExampleConditionals.Join_statements(x, y));
    }

    [Theory]
    [InlineData("foo", "world", 0)]
    [InlineData("foo", "bar", 1)]
    [InlineData("bar", "world", 2)]
    [InlineData("hello", "bar", 3)]
    [InlineData("hello", "foo", 4)]
    [InlineData("hello", "world", 5)]
    [InlineData("bar", "foo", 6)]
	void Normalize(String s1, String s2, int expected)
    {
        Assert.Equal(expected, ExampleConditionals.Normalize(s1, s2));
    }

}