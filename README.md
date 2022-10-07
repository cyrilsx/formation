# Formation Cratfman

## TDD - Legacy Code - Double loop 

Think about the test being spec.

### Naming convention
```
class MyClassShould {

  @Test void do_somthing_interesting() {
  
  }

}

```

Test creation order 

  1- Name the class
  2- Name the method
  3- Define what you are testing (write the then)
  4- Trigger the code (write the when)
  5- Setup (write the given)
  

Many kind of TDD:
 - classicist / chicago school
    (suitable for simple algorithm, e.g  roman arabic converter)
 - outside-in / london school
    (suitable for enterprise service)
   
Agile provides a lot of disappointed because professional put aside the technical side and took only the process. 
Cratfmanship was created in 2008 (by uncle Bob) as a counter-movement of Agile.  


Working with legacy code:
    - method SEAMS

### Book
 - Working effectively with legacy code (Michael Feathers)


## Crafted Design

### Introduction to Interaction-Driven Design (IDD)

#### Problem
- Badly structured packages
- Architecture and design concepts mixed with domain
- Classes and methods are too low level
- Acceptance tests either absent or badly written

#### MVC Pattern
VC -> Delivery Mechanism - Clean Code
What is model ? Problem with models

#### DDD
 Domain Model combines state and _behaviour_.
 State:
 -entities
 - vo
 - fractories
 - repositories
 - aggregate
Behaviour:
  * Services:
   - Application
   - Domain
   - Infrastructure

Repository are defined as an interface in domain model and the implementation in the infrastructure.

IDD introduce *Action*
Actions are _similar_ to Commands. It's a verb.
IDD requires to design from the outside as opposite from DDD which is design from the inside (hexagonal).

