#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
//#include <unistd.h>
#include <stdlib.h>
#include <errno.h>


int main(int argc, char *argv[])
{
	struct stat buf;
	stat("myfile.txt", &buf);
	int filesource;
	int filetarget;
	int ret;
	int b;
    
    /*Check if user entered enought input */
    
    if (argc != 5)
    {
    printf("Needs 5 Command Line Arguement. \n"); exit(1);
    }

	/* Check if the file is in the directory */

	filesource = open("myfile.txt", O_RDWR, 0600);

	if (filesource == -1)
	{
		perror("File does not exist"); exit(1);

	}

	printf("File is in the directory.\n");

	printf("The size of the file in bytes is = %d\n", buf.st_size);

	/* Get values from user */

	int start = atoi(argv[1]);

	int extract = atoi(argv[2]);

	int size = buf.st_size;

	/* check if values can be use */

	 if(start > size-1)
	{
    perror("The start of the extraction can't be bigger then the file"); exit(1);
	}

	if(extract > size-start)
	{
    perror("Extraction is bigger then the file"); exit(1);
	}
	

	printf("start = %d\n", start);
	printf("extract = %d\n", extract);
	printf("size = %d\n", size);

    /* create source file if needed */
    
     filetarget = open(argv[4], O_CREAT | O_RDWR, S_IRUSR | S_IWUSR | S_IXUSR);
     char buffer[extract]; // buffer needed to create file 

	/* seek from the start */

    lseek(filesource, start ,SEEK_SET);
    
    /* read the filesource into buffer, the buffer saves the data that will
       go into the filetarget  */
     read(filesource, buffer, extract);
     
    /* Write data from buffer into filetarget */ 
   filetarget = write(filetarget, buffer, extract);
     
    printf("%s\n", buffer); 
     
    close(filesource);
    close(filetarget);
	
	return 0;

}
