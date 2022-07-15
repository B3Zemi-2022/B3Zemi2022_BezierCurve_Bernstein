package jp.sagalab.b3semi;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public final class BezierCurve {
  public static BezierCurve create(List<Point2D.Double> _controlPoints) {
    return new BezierCurve(_controlPoints);
  }

  /**
   * ベジェ曲線をパラメーター _t で評価する
   * @param _t
   * @return 評価点
   */
  public Point2D.Double evaluate(double _t) {
    return new Point2D.Double();
    }

  /* ↓ここから必要な関数を書き足していく↓ */

  /* ↓ここから必要な関数を書き足していく↓ */

  public double com(int _i) {
    int expi = 1;
    int expn = 1;
    expn = factorial(m_controlPoints.size() - 1);
    expi = factorial(_i) * factorial(m_controlPoints.size() - 1 - _i);
    return (double) expn / expi;
  }

  public int factorial(int n){
    if(n == 0)
      return 1;
    return n * factorial(n - 1);
  }

  public Point2D.Double berstein(double _t){
    double sumx = 0;
    double sumy = 0;
    for(int i = 0; i < m_controlPoints.size(); i++){
      double Bi = com(i) * Math.pow(_t,i) * Math.pow(1-_t, m_controlPoints.size() - 1 - i);
      sumx += m_controlPoints.get(i).getX() * Bi;
      sumy += m_controlPoints.get(i).getY() * Bi;
    }
    return new Point2D.Double(sumx, sumy);
  }

  public double B(double _t, int i){
    return com(i) * Math.pow(_t,i) * Math.pow(1-_t, m_controlPoints.size() - 1 - i);
  }


  private BezierCurve(List<Point2D.Double> _controlPoints) {
    m_controlPoints = _controlPoints;
  }

  private List<Point2D.Double> tempPoints = new ArrayList<>();

  private List<Point2D.Double> m_controlPoints;
}


