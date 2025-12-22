.PHONY: all
all:
	mvn clean compile exec:java -Dexec.mainClass=Main

.PHONY: clean
clean:
	mvn clean

.PHONY: test
test:
	mvn test
