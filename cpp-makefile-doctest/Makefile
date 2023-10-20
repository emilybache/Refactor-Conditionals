runTests: out compile
	./out/ExampleConditionalsTest

compile:
	g++ -Ilib -Icode tests/ExampleConditionalsTest.cpp -oout/ExampleConditionalsTest

out:
	mkdir -p out/

clean:
	rm -rf out/
