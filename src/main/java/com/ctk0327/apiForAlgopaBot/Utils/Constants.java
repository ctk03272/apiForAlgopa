package com.ctk0327.apiForAlgopaBot.Utils;

public class Constants {
	public enum Member {
		ctk0327("전태경"), dragon4499("정수용"), drcobi("김기훈"), fluxus("임지수"), ggrn("황석진"), klee("이강"), morot2(
				"이승윤"), oyrin9595("오에린");
		final private String name;

		private Member(String name) { // enum에서 생성자 같은 역할
			this.name = name;
		}

		public String getName() { // 문자를 받아오는 함수
			return name;
		}
	}
}
