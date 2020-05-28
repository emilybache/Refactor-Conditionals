cmake_minimum_required(VERSION 3.8)
project(RefactorConditional)

set(CMAKE_CXX_STANDARD 17)

set(CMAKE_VERBOSE_MAKEFILE off)

enable_testing()
add_subdirectory(code)
add_subdirectory(lib)
add_subdirectory(tests)


