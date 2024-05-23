

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
};



#endif //CONDITIONALCLASS_H
