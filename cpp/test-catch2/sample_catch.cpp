#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"


#include "ExampleConditionals.h"

TEST_CASE("DeMorgan") {

    REQUIRE_FALSE(deMorgan(1));
    REQUIRE(deMorgan(5));
    REQUIRE(deMorgan(7));
}

TEST_CASE("Normalize") {
    REQUIRE(normalize("hello", "world") == 5);
    REQUIRE(normalize("bar", "foo") == 6);
    REQUIRE(normalize("foo", "world") == 0);
    REQUIRE(normalize("foo", "bar") == 1);
    REQUIRE(normalize("bar", "world") == 2);
    REQUIRE(normalize("hello", "bar") == 3);
    REQUIRE(normalize("hello", "foo") == 4);
}

TEST_CASE("split") {
    REQUIRE(split(3,4) == 7);
    REQUIRE(split(3,5) == 0);
}

TEST_CASE("join") {
    REQUIRE(join(3,4) == 7);
    REQUIRE(join(3,5) == 0);
}

TEST_CASE("split statements") {
    REQUIRE(split_statements(4, 1) == 12);
    REQUIRE(split_statements(3, 1) == 0);
    REQUIRE(split_statements(4, 2) == 24);
}

TEST_CASE("join statements") {
    REQUIRE(join_statements(4, 1) == 12);
    REQUIRE(join_statements(3, 1) == 0);
    REQUIRE(join_statements(4, 2) == 24);
}

TEST_CASE("redundant else") {
    REQUIRE(redundant_else(0) == 1);
    REQUIRE(redundant_else(3) == 10);
    REQUIRE(redundant_else(10) == 30);
    REQUIRE(redundant_else(30) == 0);
    REQUIRE(redundant_else(40) == 0);
}

TEST_CASE("invert") {
    REQUIRE(invert(3) == 4);
    REQUIRE(invert(4) == 3);
}


