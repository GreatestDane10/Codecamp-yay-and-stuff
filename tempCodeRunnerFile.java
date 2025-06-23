for(int i = 0;i<height;i++){//runs for each row needed
    for(int y=0;y<height-(i+1);y++){//runs for each 
System.out.print(" ");
    }
    for(int x =0; x<i+1;x++){//runs nfor each charicter
if(x==0||x==i||i==height-1){
System.out.print("x ");
}
else{
    System.out.print("  ");
}
    }
    
    System.out.println();
}