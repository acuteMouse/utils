DROP PROCEDURE  IF EXISTS getTopGroupBy;
DELIMITER $$

CREATE PROCEDURE `shop`.`getTopGroupBy` () 
BEGIN
  DECLARE done INT DEFAULT 0 ;
  DECLARE tid INT DEFAULT 0 ;
  #定义游标
  DECLARE ty CURSOR FOR 
  SELECT 
    typeId 
  FROM
    product_info 
  GROUP BY typeId ;
 
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1 ;#处理空结果
  OPEN ty ;
  read_loop :
  LOOP
    FETCH ty INTO tid ;
    IF done = 1 
    THEN LEAVE read_loop ;
    END IF ;
    SELECT 
      * 
    FROM
      product_info AS p 
    WHERE p.typeId = tid 
    LIMIT 1 ;
  END LOOP ;
  CLOSE ty ;
  
END $$

DELIMITER ;
