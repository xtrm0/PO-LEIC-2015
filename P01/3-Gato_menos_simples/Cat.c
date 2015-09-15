#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include "Animal.h"
#include "Cat.h"

// note that, since a cat is an animal, part of the cat will
// be implemented as an animal.
struct cat {
  Animal _animal;
  int _purrLevel;
  double _fluffiness;
};

Cat newCat(const char* name, int age, double weight, int purrLevel,
           double fluffiness) {
  Cat cat = (Cat)malloc(sizeof(struct cat));
  if (cat != NULL) {
    // use previously defined animal allocator
    cat->_animal = newAnimal(name, age, weight);
    if (cat->_animal == NULL) {
      free(cat);
      cat = NULL;
    }
    else {
      cat->_purrLevel = purrLevel;
      cat->_fluffiness = fluffiness;
    }
  }
  return cat;
}

// destroying the cat has to undo its construction
void destroyCat(Cat cat) {
  if (cat) {
    // first, release the animal part
    destroyAnimal(cat->_animal);
    // then, release the rest of the cat
    free(cat);
  }
}

// these functions are implemented based on the animal versions
const char* getCatName      (Cat cat) { return getAnimalName  (cat->_animal); }
int         getCatAge       (Cat cat) { return getAnimalAge   (cat->_animal); }
double      getCatWeight    (Cat cat) { return getAnimalWeight(cat->_animal); }

// these are cat-specific functions
int         getCatPurrLevel (Cat cat) { return cat->_purrLevel; }
double      getCatFluffiness(Cat cat) { return cat->_fluffiness; }

/* note that we require cat1 and cat2 to be valid cats: any of
   them being NULL pointers will result in a false comparison. */
int equalsCat(Cat cat1, Cat cat2) {
  if (cat1 == NULL || cat2 == NULL) return 0;
  return equalsAnimal(cat1->_animal, cat2->_animal) &&
      getCatPurrLevel(cat1) == getCatPurrLevel(cat2) &&
      getCatFluffiness(cat1) == getCatFluffiness(cat2);
}

// note that the output here is slightly different, because it uses the
// default animal implementation.
// we could have used the animal interface to obtain individual fields.
void printCat(Cat cat) {
  printf("== Cat ==\n");
  printAnimal(cat->_animal);
  printf("Purr level: %d\n", getCatPurrLevel(cat));
  printf("Fluffiness: %g\n", getCatFluffiness(cat));
}
