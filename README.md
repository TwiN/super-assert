# super-assert

Heavily inspired by Spring Framework's 
[Assert](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/Assert.html) 
class in `org.springframework.util` and JUnit's assertion library, SuperAssert's goal is to provide a complete
 one-line assertion solution with custom exception support.

By providing a one-line solution, developers significantly enhance the readability of their code by reducing 
the amount of lines taken by minor, but sometimes numerous checks like this:

```java
if (username == null || username.length == 0) {
	throw new Exception("...");
}
```

and instead, use an elegant one-line solution like this:

```java
SuperAssert.isTrue(username == null || username.length == 0, "...");
```

In fact, SuperAssert shines even more when you want to give more details to each specific error cases:

```java
SuperAssert.notNull(username, "Your username cannot be null");
SuperAssert.isFalse(username.isEmpty(), "Your username cannot be blank");
SuperAssert.isFalse(getUserByUsername(username), "The username you selected is already taken");
```

As this project is currently in progress, you're welcome to contribute.


## Usage

By default, SuperAssert will throw an `IllegalArgumentException` with the message passed as parameter.
It's very important to understand that `IllegalArgumentException` is an **unchecked exception**, meaning that 
using SuperAssert does not require you to declare an exception in the method's or in the constructor's `throws` clause
**unless you specify a custom checked exception**.


### Without custom exception

```java
SuperAssert.notNull(object, "The object passed as parameter cannot be null");
```


### With custom exception

```java
SuperAssert.notNull(object, new CustomException("The object passed as parameter cannot be null"));
```


## Real world examples

```java
public User getUserById(Long id) {
	SuperAssert.notNull(id, "A user cannot have a null id.");
	return userRepository.findById(id).orElse(null);
}
```


## TODO

**NOTE**: The naming is not fixed. If you have a better idea, feel free to use it.

- hasMoreThanMinLength
	- `hasMoreThanMinLength(str, minLength, message)`
	- `hasMoreThanMinLength(str, minLength, customException)`
- hasLessThanMaxLength
	- `hasLessThanMaxLength(str, maxLength, message)`
    - `hasLessThanMaxLength(str, maxLength, customException)`
- hasBetweenMinAndMaxLength
	- `hasBetweenMinAndMaxLength(str, minLength, maxLength, message)`
	- `hasBetweenMinAndMaxLength(str, minLength, maxLength, customException)`
	
