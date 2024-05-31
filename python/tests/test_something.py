import pytest

from lift_up_conditionals import lift_up_conditional, hello_world
from example_conditionals import *


def test_DeMorgan():
    assert not deMorgan(1)
    assert deMorgan(5)
    assert deMorgan(7)


def test_split():
    assert split(3, 4) == 7
    assert split(3, 5) == 0


def test_join():
    assert join(3, 4) == 7
    assert join(3, 5) == 0


def test_split_statements():
    assert split_statements(4, 1) == 12
    assert split_statements(3, 1) == 0
    assert split_statements(4, 2) == 24


def test_join_statements():
    assert join_statements(4, 1) == 12
    assert join_statements(3, 1) == 0
    assert join_statements(4, 2) == 24


def test_redundant_else():
    assert redundant_else(0) == 1
    assert redundant_else(3) == 10
    assert redundant_else(10) == 30
    assert redundant_else(30) == 0
    assert redundant_else(40) == 0


def test_invert():
    assert invert(3) == 4
    assert invert(4) == 3


def test_A_True_B_True():
    assert lift_up_conditional(True, True) == "ATrueBTrue"


def test_A_True_B_False():
    assert lift_up_conditional(True, False) == "ATrueBFalse"


def test_A_False_B_True():
    assert lift_up_conditional(False, True) == "AFalseBTrue"


def test_A_False_B_False():
    assert lift_up_conditional(False, False) == "AFalseBFalse"


def test_Normalize_hello_world():
    assert hello_world("hello", "world") == 5
    assert hello_world("bar", "foo") == 6
    assert hello_world("foo", "world") == 0
    assert hello_world("foo", "bar") == 1
    assert hello_world("bar", "world") == 2
    assert hello_world("hello", "bar") == 3
    assert hello_world("hello", "foo") == 4
