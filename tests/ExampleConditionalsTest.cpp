#define APPROVAL_TESTS_HIDE_DEPRECATED_CODE 1

#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"

using namespace ApprovalTests;

#include "ExampleConditionals.h"

TEST_CASE("DeMorgan") {

    REQUIRE_FALSE(deMorgan(1));
    REQUIRE(deMorgan(5));
    REQUIRE(deMorgan(7));
}

TEST_CASE("Normalize") {
    REQUIRE(normalize2("hello", "world") == 5);
    REQUIRE(normalize2("foo", "world") == 0);
    REQUIRE(normalize2("foo", "bar") == 1);
    REQUIRE(normalize2("bar", "world") == 2);
    REQUIRE(normalize2("hello", "bar") == 3);
    REQUIRE(normalize2("hello", "foo") == 4);
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

