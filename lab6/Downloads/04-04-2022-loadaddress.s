	.data # variables
x:	.word 5
y:	.word 0xabcd1234

st:	.asciiz "Hello, World!"

z:	.word 10

	.text # assembly instructions
main:	# load the address of x into $s0
	la $s0, x

	# load the address of y into $s1
	la $s1, y

	# load the address of z into $s2
	la $s2, z

	# load the value of x into $t0
	lw $t0, 0($s0)
	# to load value of x into $t0 using address of z
	#lw $t0, -8($s2)

	# load the value of y into $t1
	lw $t1, 0($s1)

	# load the value of z into $t2
	lw $t2, 0($s2)
	# to load value of z into $t2 using address of x
	#lw $t2, 8($s0)

	# x + y
	add $t3, $t0, $t1
	# .. + z
	add $t3, $t3, $t2

	# save the result in x
	sw $t3, 0($s0)

	jr $ra

