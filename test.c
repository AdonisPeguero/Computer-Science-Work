#include <sys/types.h>
#include <dirent.h>
#include <stdio.h>
#include <libgen.h>
#include <stdlib.h>
#include <string.h>


int main()
{
    struct dirent {
           ino_t          d_ino;       /* inode number */
           off_t          d_off;       /* offset to the next dirent */
           unsigned short d_reclen;    /* length of this record */
           unsigned char  d_type;      /* type of file; not supported
                                          by all file system types */
           char           d_name[256]; /* filename */
       };
       
     DIR *dir;
      struct dirent *dp;
    if((dir = opendir(".")) == NULL){
        printf ("Cannot open .");
        exit(1);  
    }
    while ((dp = readdir(dir)) != NULL) {
      printf("%s %i\n",dp->d_name, dp->d_ino);
    }
      
      
}

