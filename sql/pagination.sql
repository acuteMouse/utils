#二分法分页存储过程
DROP PROCEDURE  IF  EXISTS getByPage;
DELIMITER $$
#二分法分页，indexnumber页码，size 每页显示数据数，total总条数
CREATE PROCEDURE getByPage(IN indexnumber INT,IN size INT,IN total INT )
BEGIN
 DECLARE fir INT DEFAULT 0; #定义分页数据第一行
 SET fir =(indexnumber -1)*size;# 计算起始量一行
 IF (fir<1) THEN
	SET fir =0;
 END IF;
 IF (fir<total/2+1) THEN 
	 SELECT * FROM product_info LIMIT fir,size;
 ELSE 
	SET fir =total-fir-size;
	IF (fir<1) THEN
	     SET fir =0;
	 END IF;
	SELECT * FROM product_info ORDER BY id DESC LIMIT fir,size;
 END IF;
 END $$
DELIMITER ;
