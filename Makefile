.PHONY: all
all: dir
	mvn clean compile exec:java -Dexec.mainClass=Main

.PHONY: clean
clean:
	mvn clean

.PHONY: test
test:
	mvn test

.PHONY: doc
doc:
	mvn javadoc:javadoc
	open target/site/apidocs/index.html

.PHONY: dir
dir:
	mkdir -p data
