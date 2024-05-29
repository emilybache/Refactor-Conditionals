#include "ApprovalTests.hpp"
#include "doctest/doctest.h"

#include "ExampleConditionals.h"
#include "ConditionalClass.h"

TEST_CASE("DeMorgan") {

    CHECK_FALSE(deMorgan(1));
    CHECK(deMorgan(5));
    CHECK(deMorgan(7));
}


TEST_CASE("split") {
    CHECK_EQ(split(3,4), 7);
    CHECK_EQ(split(3,5), 0);
}

TEST_CASE("join") {
    CHECK_EQ(join(3,4),7);
    CHECK_EQ(join(3,5), 0);
}

TEST_CASE("split statements") {
    CHECK_EQ(split_statements(4, 1), 12);
    CHECK_EQ(split_statements(3, 1), 0);
    CHECK_EQ(split_statements(4, 2), 24);
}

TEST_CASE("join statements") {
    CHECK_EQ(join_statements(4, 1), 12);
    CHECK_EQ(join_statements(3, 1), 0);
    CHECK_EQ(join_statements(4, 2), 24);
}

TEST_CASE("redundant else") {
    CHECK_EQ(redundant_else(0), 1);
    CHECK_EQ(redundant_else(3), 10);
    CHECK_EQ(redundant_else(10), 30);
    CHECK_EQ(redundant_else(30), 0);
    CHECK_EQ(redundant_else(40), 0);
}

TEST_CASE("invert") {
    CHECK_EQ(invert(3), 4);
    CHECK_EQ(invert(4), 3);
}


TEST_CASE("ConditionalClass::lift_up_b should give correct values") {
    SUBCASE("A true B true") {
        CHECK_EQ(ConditionalClass::lift_up_b(true, true), "ATrueBTrue");
    }
    SUBCASE("A true B false") {
        CHECK_EQ(ConditionalClass::lift_up_b(true, false), "ATrueBFalse");
    }
    SUBCASE("A false B true") {
        CHECK_EQ(ConditionalClass::lift_up_b(false, true), "AFalseBTrue");
    }
    SUBCASE("A false B false") {
        CHECK_EQ(ConditionalClass::lift_up_b(false, false), "AFalseBFalse");
    }
}

TEST_CASE("Normalize hello world") {
    CHECK_EQ(ConditionalClass::hello_world("hello", "world"), 5);
    CHECK_EQ(ConditionalClass::hello_world("bar", "foo"), 6);
    CHECK_EQ(ConditionalClass::hello_world("foo", "world"), 0);
    CHECK_EQ(ConditionalClass::hello_world("foo", "bar"), 1);
    CHECK_EQ(ConditionalClass::hello_world("bar", "world"), 2);
    CHECK_EQ(ConditionalClass::hello_world("hello", "bar"), 3);
    CHECK_EQ(ConditionalClass::hello_world("hello", "foo"), 4);
}

