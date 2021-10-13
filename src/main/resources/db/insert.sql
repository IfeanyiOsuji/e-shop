set foreign_key_checks = 0;
truncate table product;
truncate table feed_back;
insert into product(`id`, `product_name`, `price`, `details`, `currency`)
            values (110,'Luxury chair', 4500, 'Wetin dey happen, we dey do spring boot class, omo anotations much o','FRC'),
                   (111, 'Luxury sofa', 4800, 'Wetin dey happen, we dey do spring boot class, omo anotations much o, ho', 'USD'),
                   (112, 'Luxury bench', 6500, 'Wetin dey happen, we dey do spring boot class, omo anotations much o, ho', 'NGN'),
                   (113, 'Luxury table', 8500, 'Wetin dey happen, we dey do spring boot class, omo anotations much o, ho', 'NGN');

set foreign_key_checks =1

