// CS120 Lab-11
#include <stdio.h>

// Here's a classic sorting algorithm -- we
// move through the data, figuring out what should be
// in the "first" spot, then in the "second", and so on.
//
// There are better, faster sorting algorithms; we're using
// this one because it's simple and easy to understand
void bubblesort(int *data, int length)
{
    int i, j;
    int temp;

    for(i = 0; i < length; ++i)
    {
        for(j = i + 1; j < length; ++j)
        {
            if (data[i] > data[j])
            {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
    }
}

void print_array(int *data, int length)
{
    for (int i = 0; i < length; ++i)
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
    
    bubblesort(x, 6);
    print_array(x, 6);
}

