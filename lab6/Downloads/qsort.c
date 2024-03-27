// CS120 Lab-11
#include <stdio.h>
#include <stdlib.h>

// Because we have the stack, and the compiler handles
// things in a consistent way, we can connect pieces of
// software written by other people together with our own
// code.
// There's a great sorting algorithm called quicksort (and
// it's quick!). It's part of the "standard library," and
// you'll note above the #include <stdlib.h>.
//
// All quicksort needs to know is how big the elements of
// an array are, and a function that will compare things
// (returning negative, zero, or positive, for >, <, ==).
//
// There's some syntax weirdness here -- qsort is expecting
// a function that does not change the values of the variables
// it passes -- that's the "const" part. It will had the
// function pointers to two elements of the array.
//
// We know that our array is integers -- so in the if statements,
// we specify that by adding the (int *) before "a" and "b".
// The * in front of it all means "go to where this points, and get
// the integer".
//
// Every language has a way of describing this; it's usually kind
// of weird and cryptic, but you'll get used to it!
int compare(const void *a, const void *b)
{
    if(*(int *)a < *(int *)b)
    {
       return -1;
    }

    if(*(int *)a > *(int *)b)
    {
        return 1;
    }
    
    return 0;
}

void print_array(int *data, int length)
{
    for(int i = 0; i < length; ++i)
    {
        printf("%d ", data[i]);
    }
    printf("\n");
}

int main()
{
    int x[] = {3, 9, 1, 2, 33, 8};

    print_array(x, 6);
    printf("--\n");

    qsort(x, 6, sizeof(int), compare);
    print_array(x, 6);
}

