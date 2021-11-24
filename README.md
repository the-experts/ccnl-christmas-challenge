# ccnl-christmas-challenge Project

```
         |
        -+-
         A
        /=\               /\  /\    ___  _ __  _ __ __    __
      i/ O \i            /  \/  \  / _ \| '__|| '__|\ \  / /
      /=====\           / /\  /\ \|  __/| |   | |    \ \/ /
      /  i  \           \ \ \/ / / \___/|_|   |_|     \  /
    i/ O * O \i                                       / /
    /=========\        __  __                        /_/    _
    /  *   *  \        \ \/ /        /\  /\    __ _  ____  | |
  i/ O   i   O \i       \  /   __   /  \/  \  / _` |/ ___\ |_|
  /=============\       /  \  |__| / /\  /\ \| (_| |\___ \  _
  /  O   i   O  \      /_/\_\      \ \ \/ / / \__,_|\____/ |_|
i/ *   O   O   * \i
/=================\
       |___|
```

Hello and Merry Christmas, ho ho ho!

Welcome to the Codecentric Christmas Code Challenge (CCCC).

In this small code challenge we are going to find the person with the biggest and most creative Christmas spirit!

Show us what your Christmas spirit looks like by tuning, decorating, enhancing (or something even cooler) our base 
Christmas image ```(./christmasImage.jpg)```.

## Timeline

**Start**: The CCCC starts on 30th of November 2021.

**End**: You can send your image and link to your github repo before 24th of December 2021!

**Winner**: On the 3th of January 2022 we will announce the winner of the CCCC! 

## How to win

We will decide who is the winner of the challenge based the following criteria:

1. The original image must be somehow contained in the deliverable.

2. Code quality.

3. Most of all creativity and Christmas spirit :D.

Once you have finished the CCCC to your liking you can submit the following information to **codechallenge@codecentric.nl**:

** Your Name**

**Your Address**

**Your Christmas image attached as a jpeg file**

**Link to your github repo** (where we can have a look at your code and how you brought your Christmas spirit to us. 
Make sure it is public ;) )


## Prices, ka-chinggggg
Between **15-29** original images submitted: you can win a **Razer BlackWidow V3 Gaming Toetsenbord** 
(Worth: 150 euro's)

<img src="https://user-images.githubusercontent.com/36627455/143019333-bf3d515c-565a-479d-af7c-b26879f0144e.png" alt="Screenshot 2021-11-23 at 12 50 35" width="400"/>

Between **30-39** original images submitted:  you can win a **Samsung Odyssey G5 Curved Gaming Monitor 
(144hz)** (Worth: 325 euro's)

<img src="https://user-images.githubusercontent.com/36627455/142604367-5bf3bf73-2dc9-446e-bdd6-bf0186040cdb.png" alt="Screenshot 2021-11-19 at 11 03 00" width="400"/>


At least **40** original images submitted or more: you can win the new **Nintendo Switch Oled** (Worth: 400 
euro's)

<img src="https://user-images.githubusercontent.com/36627455/142602456-568fa04e-acf2-4d90-86fa-613707b79d7b.jpeg" alt="oled" width="400"/>

##Other Rules of Engagement
- Participants must be 18 years or older at the time of their final submission
- Participants must have their current address in the Netherlands
- The prices named in section "Prices, ka-chinggggg" can be exchanged by codecentric at free will if the named prices 
  should become unavailable for purchase or a radical price change takes place. Replacement prices will remain in the same 
  price category in terms of monetary value.
- Participants may only participate once. If one indivivual should submit multiple times, codecentric will only 
  regard the last submission, and disregard the rest.
- 

## Provided Code
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

It is required to run the project

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
quarkus dev
```

The image will be available on: http://localhost:8080/xmas/vibesAtCCNL

Or will be generated when executing the test file.

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ccnl-christmas-challenge-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides

- Quarkus Extension for Spring Web API ([guide](https://quarkus.io/guides/spring-web)): Use Spring Web annotations to create your REST services


### Spring Web

Spring, the Quarkus way! Start your RESTful Web Services with a Spring Controller.

[Related guide section...](https://quarkus.io/guides/spring-web#greetingcontroller)
