package di_0828.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"di_0828.service"}) // �˻��� ������Ʈ�� 1���� ��� �߰�ȣ ���� ����, ���� ���� ��� �߰�ȣ �ʼ�
public class AppContext2 {

}
