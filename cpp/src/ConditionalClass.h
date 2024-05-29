

#ifndef CONDITIONALCLASS_H
#define CONDITIONALCLASS_H

#include <string>

class ConditionalClass {
private:
    static std::string ATrueBTrue() { return "ATrueBTrue"; }
    static std::string ATrueBFalse() { return "ATrueBFalse"; }
    static std::string AFalseBTrue() { return "AFalseBTrue"; }
    static std::string AFalseBFalse() { return "AFalseBFalse"; }

public:
    static std::string LiftUpConditional(bool a, bool b) {
        if (a) {
            if (b) {
                return ATrueBTrue();
            } else {
                return ATrueBFalse();
            }
        } else {
            if (b) {
                return AFalseBTrue();
            } else {
                return AFalseBFalse();
            }
        }
    }

    static int hello_world(std::string s1, std::string s2) {
        if (s1 != "hello") {
            if (s2 != "world") {
                if (s1 != "foo") {
                    return 6;
                }
                return 1;
            } else if (s1 != "foo") {
                return 2;
            }
        } else {
            if (s2 == "bar") {
                return 3;
            } else if (s2 != "world") {
                return 4;
            }
            return 5;
        }
        return 0;
    }

};



#endif //CONDITIONALCLASS_H
