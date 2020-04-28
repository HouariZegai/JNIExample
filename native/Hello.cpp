#include "Hello.h"

JNIEXPORT void JNICALL Java_Hello_sayHello
  (JNIEnv *, jobject) {
	printf("Hello form cpp");
}