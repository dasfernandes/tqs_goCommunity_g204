import { AllfundraisersModule } from './allfundraisers.module';

describe('AllfundraisersModule', () => {
  let allfundraisersModule: AllfundraisersModule;

  beforeEach(() => {
    allfundraisersModule = new AllfundraisersModule();
  });

  it('should create an instance', () => {
    expect(allfundraisersModule).toBeTruthy();
  });
});
