#define DOCTEST_CONFIG_IMPLEMENT_WITH_MAIN

#include "doctest.h"
#include "ExampleConditionals.h"

TEST_CASE("DeMorgan") {

    CHECK_FALSE(deMorgan(1));
    CHECK(deMorgan(5));
    CHECK(deMorgan(7));
}

TEST_CASE("Normalize") {
    CHECK_EQ(normalize("hello", "world"), 5);
    CHECK_EQ(normalize("bar", "foo"), 6);
    CHECK_EQ(normalize("foo", "world"), 0);
    CHECK_EQ(normalize("foo", "bar"), 1);
    CHECK_EQ(normalize("bar", "world"), 2);
    CHECK_EQ(normalize("hello", "bar"), 3);
    CHECK_EQ(normalize("hello", "foo"), 4);
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

