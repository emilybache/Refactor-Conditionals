#include <ConditionalClass.h>

#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"


#include "ExampleConditionals.h"
#include "ConditionalClass.h"

TEST_CASE("DeMorgan") {

    REQUIRE_FALSE(deMorgan(1));
    REQUIRE(deMorgan(5));
    REQUIRE(deMorgan(7));
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

TEST_CASE("ConditionalClass::lift_up_b should give correct values", "[ConditionalClass]") {
    SECTION("A true B true") {
        REQUIRE(ConditionalClass::lift_up_b(true, true) == "ATrueBTrue");
    }
    SECTION("A true B false") {
        REQUIRE(ConditionalClass::lift_up_b(true, false) == "ATrueBFalse");
    }
    SECTION("A false B true") {
        REQUIRE(ConditionalClass::lift_up_b(false, true) == "AFalseBTrue");
    }
    SECTION("A false B false") {
        REQUIRE(ConditionalClass::lift_up_b(false, false) == "AFalseBFalse");
    }
}

TEST_CASE("Normalize hello world") {
  CHECK(ConditionalClass::hello_world("hello", "world") == 5);
  CHECK(ConditionalClass::hello_world("bar", "foo") == 6);
  CHECK(ConditionalClass::hello_world("foo", "world") == 0);
  CHECK(ConditionalClass::hello_world("foo", "bar") == 1);
  CHECK(ConditionalClass::hello_world("bar", "world") == 2);
  CHECK(ConditionalClass::hello_world("hello", "bar") == 3);
  CHECK(ConditionalClass::hello_world("hello", "foo") == 4);
}

