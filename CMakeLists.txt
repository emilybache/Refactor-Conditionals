cmake_minimum_required(VERSION 3.8)
project(RefactorConditional)

set(CMAKE_CXX_STANDARD 17)

set(CMAKE_VERBOSE_MAKEFILE off)

# uncomment these lines to enable coverage measurements using gcov
#set(CMAKE_C_FLAGS "--coverage")
set(CMAKE_CXX_FLAGS "--coverage")

enable_testing()
add_subdirectory(code)
add_subdirectory(lib)
add_subdirectory(tests)


